package domain.winningStatistics;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private final Map<PrizeMoney, Integer> winningStatistics = new HashMap<>();

    public WinningStatistics() {
        initiate();
    }

    private void initiate() {
        for (PrizeMoney value : PrizeMoney.values()) {
            winningStatistics.put(value, 0);
        }
    }

    public void win(PrizeMoney value) {
        winningStatistics.put(value, winningStatistics.get(value) + 1);
    }

    public int get(PrizeMoney value) {
        return winningStatistics.get(value);
    }

    public Map<PrizeMoney, Integer> getWinningStatistics() {
        return winningStatistics;
    }
}
