package domain.winningStatistics;

import java.util.*;

public class WinningStatistics {
    private Map<PrizeMoney, Integer> winningStatistics = new HashMap<>();


    public WinningStatistics() {
        initiate();
    }

    private void initiate() {
        for (PrizeMoney value : PrizeMoney.values()) {
            winningStatistics.put(value, 0);
        }
    }

    public void increase(PrizeMoney value) {
        winningStatistics.put(value, winningStatistics.get(value) + 1);
    }

    public int get(PrizeMoney value) {
        return winningStatistics.get(value);
    }

    public Map<PrizeMoney, Integer> getWinningStatistics() {
        return winningStatistics;
    }
}
