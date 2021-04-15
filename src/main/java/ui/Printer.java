package ui;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import domain.lotteryStore.Lotteries;
import domain.lotteryStore.numbers.Lottery;
import domain.winningStatistics.Ranking;
import domain.winningStatistics.WinningStatistics;
import ui.message.OutputMessage;

public class Printer {
    private static final int SIZE_OF_RANK = 5;
    private static final int WIN_WITH_BONUS_NUMBER = 3;

    public void printPurchasedCount(int manualCount, int purchasedCount) {
        System.out.printf(OutputMessage.PURCHASED_COUNT.getMessage(), manualCount, purchasedCount - manualCount);
    }

    public void printPurchasedLotteries(Lotteries lotteries) {
        List<List<Integer>> lotteriesNumbers = lotteries.getLotteries()
            .stream()
            .map(Lottery::getNumbers)
            .collect(Collectors.toList());

        lotteriesNumbers.forEach(Collections::sort);
        lotteriesNumbers.forEach(System.out::println);
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        StringBuilder builder = new StringBuilder();
        Ranking[] prizeMonies = Ranking.values();

        builder.append(OutputMessage.WINNING_STATISTICS.getMessage());

        for (int i = 0; i < SIZE_OF_RANK; i++) {
            printWinningStatisticsDetails(builder, prizeMonies[i], winningStatistics.get(prizeMonies[i]), i);
        }
        System.out.print(builder);
    }

    private void printWinningStatisticsDetails(StringBuilder builder, Ranking ranking, Integer result, int i) {
        if (i == WIN_WITH_BONUS_NUMBER) {
            builder.append(
                String.format(OutputMessage.MATCH_COUNT_WITH_BONUS.getMessage(), ranking.getMatchingCount(),
                    ranking.getPrizeMoney(), result));
            return;
        }
        builder.append(String.format(OutputMessage.MATCH_COUNT.getMessage(), ranking.getMatchingCount(),
            ranking.getPrizeMoney(), result));
    }

    public void printTotalEarningsRate(double totalEarningsRate) {
        System.out.printf(OutputMessage.TOTAL_EARNINGS_RATE.getMessage(), totalEarningsRate);
    }
}
