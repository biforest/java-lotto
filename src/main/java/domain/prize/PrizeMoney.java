package domain.prize;

import java.util.List;

public enum PrizeMoney {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int matchingCount;
    private final int prizeMoney;

    PrizeMoney(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static float calculateEarningsRate(WinningStatistics winningStatistics, int purchasedCount) {
        List<Integer> sizeOfWinnersPerRank = winningStatistics.getRankings();
        int totalPrizeMoney = 0;
        for (int i = 0; i < 5; i++) {
            totalPrizeMoney += sizeOfWinnersPerRank.get(i) * (PrizeMoney.values())[i].prizeMoney;
        }

        return (float)totalPrizeMoney / (purchasedCount * 1000);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
