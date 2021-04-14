package domain.winningStatistics;

import domain.lotteryStore.PurchasePrice;

import java.util.Arrays;
import java.util.List;

import static domain.lotteryStore.PurchasePrice.PRICE_OF_ONE_LOTTERY_TICKET;

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

    public static double calculateEarningsRate(WinningStatistics winningStatistics, int purchasedCount) {
        int totalPrizeMoney = Arrays.stream(values())
                .mapToInt(money -> winningStatistics.get(money) * money.prizeMoney)
                .sum();

        return (double)totalPrizeMoney / (purchasedCount * PRICE_OF_ONE_LOTTERY_TICKET);
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
