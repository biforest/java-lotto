package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private static final double NO_PRIZE = 0;

    private final List<GameResult> results;

    public GameResults(List<GameResult> results) {
        this.results = new ArrayList<>(results);
    }

    public double calculatePrize() {
        return results.stream()
                .map(GameResult::getPrize)
                .mapToDouble(Double::valueOf)
                .reduce(Double::sum)
                .orElse(NO_PRIZE);
    }

    public int count(GameResult gameResult) {
        return Long.valueOf(
                results.stream()
                        .filter(gameResult::equals)
                        .count()
        ).intValue();
    }
}
