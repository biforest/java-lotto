package lotto.domain.dto;

import lotto.domain.result.GameResult;

public class WinningResult {

    private final int numberOfWinners;
    private final GameResult gameResult;

    public WinningResult(int numberOfWinners, GameResult gameResult) {
        this.numberOfWinners = numberOfWinners;
        this.gameResult = gameResult;
    }

    public int getNumberOfWinners() {
        return numberOfWinners;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
