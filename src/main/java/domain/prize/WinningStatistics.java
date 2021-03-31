package domain.prize;

import java.util.List;

public class WinningStatistics {
    private final List<Integer> matchingCounts;

    public WinningStatistics(List<Integer> matchingCounts) {
        this.matchingCounts = matchingCounts;
    }

    public List<Integer> getMatchingCounts() {
        return matchingCounts;
    }
}
