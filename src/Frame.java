import java.util.ArrayList;
import java.util.List;

public class Frame {

    private int score;
    List<Roll> rolls;
    private int bonusScore;

    public Frame() {
        score = 0;
        bonusScore = 0;
        rolls = new ArrayList<>();
    }

    public void setScore(int pins) {
        Roll roll = new Roll(pins);
        rolls.add(roll);
    }

    public void setBonusScore(int pins) {
        bonusScore += pins;
    }

    public int getScore() {
        int rollScore = rolls.stream()
             .mapToInt(r -> r.getScore())
             .sum();
        score = rollScore + bonusScore;
        return score;
    }

    public boolean isSpare() {
        return rolls.size() == 2 && this.getScore() == 10;
    }

    public boolean isStrike() {
        return rolls.get(0).getScore() == 10;
    }

    public int size() {
        return rolls.size();
    }
}
