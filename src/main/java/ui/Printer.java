package ui;

import java.util.List;

import domain.lotteryStore.Lotteries;
import domain.prize.Result;
import domain.prize.WinningStatistics;

public class Printer {

    public int printPurchasedCount(int purchasePrice) {
        int purchasedCount = purchasePrice / 1000;
        System.out.println(purchasedCount + Message.OutputMessage.PURCHASED_COUNT.getMessage());
        return purchasedCount;
    }

    public void printPurchasedLotteries(Lotteries lotteries) {
        lotteries.getLotteries()
            .stream()
            .map(lottery -> lottery.getNumbers().getNumbers())
            .forEach(System.out::println);
    }

    public void printWinningStatistics(Result result) {
        StringBuilder builder = new StringBuilder();
        WinningStatistics[] prizeMonies = WinningStatistics.values();
        List<Integer> results = result.getResult();

        builder.append(Message.OutputMessage.WINNING_STATISTICS.getMessage())
            .append(Message.OutputMessage.BOUNDARY_LINE.getMessage());
        for (int i = 0; i < 5; i++) {
            printWinningStatisticsDetails(builder, prizeMonies[i], results.get(i), i);
        }
        System.out.print(builder);
    }

    private void printWinningStatisticsDetails(StringBuilder builder, WinningStatistics winningStatistics,
        Integer result, int i) {
        builder.append(winningStatistics.getMatchingCount());
        if (i == 3) {
            builder.append(Message.OutputMessage.MATCH_COUNT_BONUS.getMessage());
        }
        if (i != 3) {
            builder.append(Message.OutputMessage.MATCH_COUNT.getMessage());
        }
        builder.append(winningStatistics.getPrizeMoney())
            .append(Message.OutputMessage.WON.getMessage())
            .append(result)
            .append(Message.OutputMessage.COUNT.getMessage());
    }

    public void printTotalEarningsRate(float totalEarningsRate) {
        System.out.println(
            Message.OutputMessage.TOTAL_EARNINGS_RATE.getMessage() + String.format("%.2f", totalEarningsRate)
                + Message.OutputMessage.CLOSING_MENTION.getMessage());
    }
}
