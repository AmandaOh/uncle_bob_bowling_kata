
public class TenthFrame extends Frame {

    public void setScore(int pins) {
        if (!gameOver()) {
            super.setScore(pins);
        } else {
            System.out.println("Game Over");
        }
    }

    private boolean gameOver() {
        return (rolls.size() == 3) || (rolls.size() == 2 && !rollsBeforeIsAStrikeOrSpare());
    }

    private boolean rollsBeforeIsAStrikeOrSpare() {
        return (rolls.get(0).getScore() == 10)|| (rolls.get(0).getScore() + rolls.get(1).getScore() == 10);
    }

}
