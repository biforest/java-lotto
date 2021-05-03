package domain.winningStatistics;

import java.util.Arrays;

import domain.lotteryStore.PurchasePrice;

public enum Ranking {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int matchingCount;
    private final int prizeMoney;

    Ranking(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static double calculateEarningsRate(WinningStatistics winningStatistics, int purchasedCount) {
        int totalPrizeMoney = Arrays.stream(values())
            .mapToInt(ranking -> winningStatistics.get(ranking) * ranking.prizeMoney)
            .sum();

        return (double)totalPrizeMoney / (purchasedCount * PurchasePrice.PRICE_OF_ONE_LOTTERY_TICKET);
    }

    public boolean isSameMatchingCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
