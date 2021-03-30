package ui;

import java.util.List;

import domain.Lotteries;
import domain.Message;
import domain.PrizeMoney;
import domain.Result;

public class Printer {

    public int printPurchasedCount(int purchasePrice) {
        int purchasedCount = purchasePrice / 1000;
        System.out.println(purchasedCount + Message.PURCHASED_COUNT.getMessage());
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
        PrizeMoney[] prizeMonies = PrizeMoney.values();
        List<Integer> results = result.getResult();

        builder.append(Message.WINNING_STATISTICS.getMessage()).append(Message.BOUNDARY_LINE.getMessage());
        for (int i = 0; i < 5; i++) {
            printWinningStatisticsDetails(builder, prizeMonies[i], results.get(i), i);
        }
        System.out.print(builder);
    }

    private void printWinningStatisticsDetails(StringBuilder builder, PrizeMoney prizeMoney, Integer result, int i) {
        builder.append(prizeMoney.getMatchingCount());
        if (i == 3) {
            builder.append(Message.MATCH_COUNT_BONUS.getMessage());
        }
        if (i != 3) {
            builder.append(Message.MATCH_COUNT.getMessage());
        }
        builder.append(prizeMoney.getPrizeMoney())
            .append(Message.WON.getMessage())
            .append(result)
            .append(Message.COUNT.getMessage());
    }

    public void printTotalEarningsRate(float totalEarningsRate) {
        System.out.println(Message.TOTAL_EARNINGS_RATE.getMessage() + String.format("%.2f", totalEarningsRate)
            + Message.CLOSING_MENTION.getMessage());
    }
}
