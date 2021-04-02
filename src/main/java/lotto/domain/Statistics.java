package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    private static final int IS_EQUAL_RATE = 1;

    private final GameResults gameResults;
    private final int purchaseAmount;

    public Statistics(GameResults gameResults, int purchaseAmount) {
        this.gameResults = gameResults;
        this.purchaseAmount = purchaseAmount;
    }

    public List<WinningResult> winningResults() {
        return GameResult.valuesWithoutUnderThreeMatched()
                .stream()
                .map(gameResult -> new WinningResult(gameResults.count(gameResult), gameResult))
                .collect(Collectors.toList());
    }

    public double calculateEarningRate() {
        return gameResults.calculatePrize() / purchaseAmount;
    }

    public boolean isProfit(double earningRate) {
        return earningRate > IS_EQUAL_RATE;
    }
}
