import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void testGame() {
        Game g = new Game();
    }

    @Test
    public void gameReturnsScoreForFirstRoll() {
        Game g = new Game();
        g.roll(3);
        assertEquals(3, g.score());
    }

    @Test
    public void gameReturnsScoreOf6ForRollOf3And3() {
        Game g = new Game();
        g.roll(3);
        g.roll(3);
        assertEquals(6, g.score());
    }

    @Test
    public void gameReturnsScoreOf9ForRollOf3And3And3() {
        Game g = new Game();
        g.roll(3);
        g.roll(3);
        g.roll(3);
        assertEquals(9, g.score());
    }

    @Test
    public void gameReturnsScoreOf16ForRollOf6_4_3() {
        Game g = new Game();
        g.roll(6);
        g.roll(4);
        g.roll(3);
        assertEquals(16, g.score());
    }

    @Test
    public void gameReturnsScoreOf18ForRollOf3_7_4() {
        Game g = new Game();
        g.roll(3);
        g.roll(7);
        g.roll(4);
        assertEquals(18, g.score());
    }

    @Test
    public void gameReturnsScoreOf22ForRollOf10_3_3() {
        Game g = new Game();
        g.roll(10);
        g.roll(3);
        g.roll(3);
        assertEquals(22, g.score());
    }

    @Test
    public void gameReturnsScoreOf34ForRollOf10_4_6_2() {
        Game g = new Game();
        g.roll(10);
        g.roll(4);
        g.roll(6);
        g.roll(2);
        assertEquals(34, g.score());
    }

    @Test
    public void gameReturnsScoreOf70ForRollOf10_10_10_2_2() {
        Game g = new Game();
        g.roll(10);
        g.roll(10);
        g.roll(10);
        g.roll(2);
        g.roll(2);
        assertEquals(70, g.score());
    }

    @Test
    public void gameReturnsScoreOf44ForRollOf10_0_10_6_2() {
        Game g = new Game();
        g.roll(10);
        g.roll(0);
        g.roll(10);
        g.roll(6);
        g.roll(2);
        assertEquals(44, g.score());
    }

    @Test
    public void gameReturnsScoreOf76ForRollOf10_0_10_10_0_10_3() {
        Game g = new Game();
        g.roll(10);
        g.roll(0);
        g.roll(10);
        g.roll(10);
        g.roll(0);
        g.roll(10);
        g.roll(3);
        assertEquals(76, g.score());
    }

    @Test
    public void gameReturnsScoreOf90ForRollOf10_3_7_10_3_7_10() {
        Game g = new Game();
        g.roll(10);
        g.roll(3);
        g.roll(7);
        g.roll(10);
        g.roll(3);
        g.roll(7);
        g.roll(10);
        assertEquals(90, g.score());
    }

    @Test
    public void gameReturnsScoreOf192ForStreakOfStrikeAndSpares() {
        Game g = new Game();
        for(int i = 0; i < 5; i++) {
            g.roll(10);
            g.roll(3);
            g.roll(7);
        }
        g.roll(2);
        assertEquals(192, g.score());
    }

    @Test
    public void gameReturnsScoreOfForSteakOfSpares() {
        Game g = new Game();
        for(int i = 0; i < 5; i++) {
            g.roll(4);
            g.roll(6);
            g.roll(3);
            g.roll(7);
        }
        g.roll(2);
        assertEquals(133, g.score());
    }

    @Test
    public void gameReturnsScoreOf300ForAllStrikes() {
        Game g = new Game();
        for (int i = 0; i < 12; i++) {
            g.roll(10);
        }
        assertEquals(300, g.score());
    }

}