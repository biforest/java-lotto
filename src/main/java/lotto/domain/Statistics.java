package lotto.domain;

import lotto.domain.dto.WinningResult;
import lotto.domain.lotto.PurchaseAmount;
import lotto.domain.result.GameResult;
import lotto.domain.result.GameResults;

import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    private static final int IS_EQUAL_RATE = 1;

    private final GameResults gameResults;
    private final PurchaseAmount purchaseAmount;

    public Statistics(GameResults gameResults, PurchaseAmount purchaseAmount) {
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
        return gameResults.calculatePrize() / purchaseAmount.getPurchaseAmount();
    }

    public boolean isProfit(double earningRate) {
        return earningRate > IS_EQUAL_RATE;
    }
}
