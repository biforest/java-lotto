package lotto.domain;
import java.util.List;
import java.util.stream.Collectors;
public class Statistics {
    private final GameResults gameResults;
    private final int purchaseAmount;
    public Statistics(GameResults gameResults, int purchaseAmount) {
        this.gameResults = gameResults;
        this.purchaseAmount = purchaseAmount;
    }
    public List<WinningResult> winningDTOs() {
        return GameResult.valuesWithoutUnderThreeMatched()
                .stream()
                .map(gameResult -> new WinningResult(gameResults.count(gameResult), gameResult))
                .collect(Collectors.toList());
    }
    public double calculateEarningRate() {
        return gameResults.calculatePrize() / purchaseAmount;
    }
    public boolean isProfit(double earningRate) {
        return earningRate > 1;
    }
}