package ui;

import java.util.List;
import java.util.Map;

import domain.lotteryStore.Lotteries;
import domain.winningStatistics.PrizeMoney;
import domain.winningStatistics.WinningStatistics;
import ui.message.OutputMessage;

public class Printer {
    private static final int SIZE_OF_RANK = 5;
    private static final int WIN_WITH_BONUS_NUMBER = 3;

    public void printPurchasedCount(int manualCount, int purchasedCount) {
        System.out.printf(OutputMessage.PURCHASED_COUNT.getMessage(), manualCount, purchasedCount - manualCount);
    }

    public void printPurchasedLotteries(Lotteries lotteries) {
        lotteries.getLotteries()
                .stream()
                .map(lottery -> lottery.getNumbers().getNumbers())
                .forEach(System.out::println);
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        StringBuilder builder = new StringBuilder();
        PrizeMoney[] prizeMonies = PrizeMoney.values();

        builder.append(OutputMessage.WINNING_STATISTICS.getMessage());

        for (int i = 0; i < SIZE_OF_RANK; i++) {
            printWinningStatisticsDetails(builder, prizeMonies[i], winningStatistics.get(prizeMonies[i]), i);
        }
        System.out.print(builder);
    }

    private void printWinningStatisticsDetails(StringBuilder builder, PrizeMoney prizeMoney, Integer result, int i) {
        if (i == WIN_WITH_BONUS_NUMBER) {
            builder.append(
                    String.format(OutputMessage.MATCH_COUNT_WITH_BONUS.getMessage(), prizeMoney.getMatchingCount(),
                            prizeMoney.getPrizeMoney(), result));
            return;
        }
        builder.append(String.format(OutputMessage.MATCH_COUNT.getMessage(), prizeMoney.getMatchingCount(),
                prizeMoney.getPrizeMoney(), result));
    }

    public void printTotalEarningsRate(float totalEarningsRate) {
        System.out.printf(OutputMessage.TOTAL_EARNINGS_RATE.getMessage(), totalEarningsRate);
    }
}
