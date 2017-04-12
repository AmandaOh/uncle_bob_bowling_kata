import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by amanda on 11/04/2017.
 */
public class FrameTest {

    @Test
    public void newFrameStartsWithScore0() {
        Frame frame = new Frame();
        assertEquals(0, frame.getScore());
    }

    @Test
    public void scoreIs3WhenPlayerRolls3() {
        Frame frame = new Frame();
        frame.setScore(3);
        assertEquals(3, frame.getScore());
    }

    @Test
    public void scoreIs6WhenPlayerRolls3and3() {
        Frame frame = new Frame();
        frame.setScore(3);
        frame.setScore(3);
        assertEquals(6, frame.getScore());
    }

    @Test
    public void isSpareIsTrueWhenPlayerRolls4and6() {
        Frame frame = new Frame();
        frame.setScore(4);
        frame.setScore(6);
        assertTrue(frame.isSpare());
    }

    @Test
    public void isStrikeIsTrueWhenPlayerRolls10() {
        Frame frame = new Frame();
        frame.setScore(10);
        assertTrue(frame.isStrike());
        assertFalse(frame.isSpare());
    }

}