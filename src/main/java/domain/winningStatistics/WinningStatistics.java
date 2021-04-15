package domain.winningStatistics;

import java.util.EnumMap;
import java.util.Map;

public class WinningStatistics {
    private final Map<Ranking, Integer> winningStatistics = new EnumMap<>(Ranking.class);

    public WinningStatistics() {
        initiate();
    }

    private void initiate() {
        for (Ranking value : Ranking.values()) {
            winningStatistics.put(value, 0);
        }
    }

    public void win(Ranking value) {
        winningStatistics.put(value, winningStatistics.get(value) + 1);
    }

    public int get(Ranking value) {
        return winningStatistics.get(value);
    }

    public Map<Ranking, Integer> getWinningStatistics() {
        return winningStatistics;
    }
}
