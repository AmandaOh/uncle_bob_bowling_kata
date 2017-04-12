import org.junit.Test;

import static org.junit.Assert.*;

public class TenthFrameTest {
    @Test
    public void frameGetsScoreOf3whenPlayerRolls3() {
        TenthFrame frame = new TenthFrame();
        frame.setScore(3);
        assertEquals(3, frame.getScore());
    }

    @Test
    public void frameScoreIs6WhenPlayerRolls3_3() {
        TenthFrame frame = new TenthFrame();
        frame.setScore(3);
        frame.setScore(3);
        assertEquals(6, frame.getScore());
    }

    @Test
    public void isSpareIsTrueWhenPlayerRolls4and6() {
        TenthFrame frame = new TenthFrame();
        frame.setScore(4);
        frame.setScore(6);
        assertTrue(frame.isSpare());
    }

    @Test
    public void scoreIs12WhenPlayerRolls3_7_2(){
        TenthFrame frame = new TenthFrame();
        frame.setScore(3);
        frame.setScore(7);
        frame.setScore(2);
        assertEquals(12, frame.getScore());
    }

    @Test
    public void isStrikeIsTrueWhenPlayerRolls10() {
        TenthFrame frame = new TenthFrame();
        frame.setScore(10);
        assertTrue(frame.isStrike());
        assertFalse(frame.isSpare());
    }

    @Test
    public void hasScoreOf30WhenPlayerRolls3Strikes() {
        TenthFrame frame = new TenthFrame();
        frame.setScore(10);
        frame.setScore(10);
        frame.setScore(10);
        assertEquals(30, frame.getScore());
    }

    @Test
    public void showsGameOverAfter2RollsOf3_3() {
        TenthFrame frame = new TenthFrame();
        frame.setScore(3);
        frame.setScore(3);
        frame.setScore(3);
        assertEquals(6, frame.getScore());
    }
    @Test
    public void showsGameOverAfterRollsOf10_0_10_2() {
        TenthFrame frame = new TenthFrame();
        frame.setScore(10);
        frame.setScore(0);
        frame.setScore(10);
        frame.setScore(2);
        assertEquals(20, frame.getScore());
    }

    @Test
    public void scoreIs20AfterRollsOf0_10_10() {
        TenthFrame frame = new TenthFrame();
        frame.setScore(0);
        frame.setScore(10);
        frame.setScore(10);
        frame.setScore(10);
        assertEquals(20, frame.getScore());
    }
}