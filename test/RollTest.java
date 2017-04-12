import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by amanda on 11/04/2017.
 */
public class RollTest {

    @Test
    public void getsScoreWhenPlayerRolls() {
        Roll roll = new Roll(3);
        assertEquals(3, roll.getScore());
    }

}