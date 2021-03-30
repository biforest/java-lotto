package domain.prize;

import java.util.List;

public enum WinningStatistics {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int matchingCount;
    private final int prizeMoney;

    WinningStatistics(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static float calculateEarningsRate(Result result, int purchasePrice) {
        List<Integer> matchingCounts = result.getResult();
        int totalPrizeMoney = 0;
        for (int i = 0; i < 5; i++) {
            totalPrizeMoney += matchingCounts.get(i) * (WinningStatistics.values())[i].prizeMoney;
        }

        return (float)totalPrizeMoney / purchasePrice;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
