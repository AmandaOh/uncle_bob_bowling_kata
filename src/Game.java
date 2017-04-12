import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Frame> game;
    private int noOfFrames;
    private int rollNumber;
    Frame currentFrame;
    Frame previousFrame;
    Frame twoFramesBefore;
    int currentFrameNumber;
    private int score;

    public Game() {
        rollNumber = 0;
        currentFrameNumber = 0;
        noOfFrames = 10;
        game = new ArrayList<>(noOfFrames);
        for (int i = 0; i < 9; i++) {
            game.add(new Frame());
        }
        game.add(new TenthFrame());
        currentFrame = game.get(currentFrameNumber);
    }

    public void roll(int pins) {
        if (currentFrame.size() == 2 && !(currentFrame instanceof TenthFrame)) {
            moveToNextFrame();
        }
            accrualBonusPoints(pins);
            currentFrame.setScore(pins);
        if (pins == 10 && !(currentFrame instanceof TenthFrame)) {
            moveToNextFrame();
        }
        rollNumber += 1;
    }

    private void accrualBonusPoints(int pins) {
        if (previousFrame != null) {
            if (previousFrame.isSpare()) {
                previousFrame.setBonusScore(pins);
            } else if (previousFrame.isStrike() && currentFrame.size() < 2) {
                previousFrame.setBonusScore(pins);
            }
        }
        if (twoFramesBefore != null) {
            if (twoFramesBefore.isStrike() && previousFrame.isStrike() && currentFrame.size() == 0) {
                twoFramesBefore.setBonusScore(pins);
            }
        }
    }

    private void moveToNextFrame() {
        currentFrameNumber += 1;
        currentFrame = game.get(currentFrameNumber);
        previousFrame = game.get(currentFrameNumber - 1);
        if (currentFrameNumber - 2 >= 0) {
            twoFramesBefore = game.get(currentFrameNumber - 2);
        }
    }

    public int score() {
        score = game.stream()
                .mapToInt(x -> x.getScore())
                .sum();
        //        for (int i = 0; i < game.size(); i++) {
        //            System.out.println(game.get(i).getScore());
        //        }
        return score;
    }

}
