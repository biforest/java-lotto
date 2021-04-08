package domain.winningStatistics;

import java.util.Arrays;

public enum PrizeMoney {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int matchingCount;
    private final boolean isHavingBonusNumber;
    private final int prizeMoney;

    PrizeMoney(int matchingCount, boolean isHavingBonusNumber, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.isHavingBonusNumber = isHavingBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static float calculateEarningsRate(WinningStatistics winningStatistics, int purchasedCount) {
        int totalPrizeMoney = Arrays.stream(values())
            .mapToInt(prizeMoney -> winningStatistics.get(prizeMoney) * prizeMoney.getPrizeMoney())
            .sum();

        return (float)totalPrizeMoney / (purchasedCount * 1000);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isHavingBonusNumber() {
        return isHavingBonusNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
