package ui;

import java.util.List;

import domain.lotteryStore.Lotteries;
import domain.prize.PrizeMoney;
import domain.prize.WinningStatistics;
import ui.message.OutputMessage;

public class Printer {
    private static final int PRICE_OF_ONE_LOTTERY_TICKET = 1000;
    private static final int SIZE_OF_LOTTERY_RANK = 5;
    private static final int WIN_WITH_BONUS_NUMBER = 3;
    private static final String LIMIT_OF_DECIMAL_PLACE = "%.2f";

    public int printPurchasedCount(int purchasePrice) {
        int purchasedCount = purchasePrice / PRICE_OF_ONE_LOTTERY_TICKET;
        System.out.println(purchasedCount + OutputMessage.PURCHASED_COUNT.getMessage());
        return purchasedCount;
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
        List<Integer> sizeOfWinnersPerRank = winningStatistics.getRankings();

        builder.append(OutputMessage.WINNING_STATISTICS.getMessage())
            .append(OutputMessage.BOUNDARY_LINE.getMessage());
        for (int i = 0; i < SIZE_OF_LOTTERY_RANK; i++) {
            printWinningStatisticsDetails(builder, prizeMonies[i], sizeOfWinnersPerRank.get(i), i);
        }
        System.out.print(builder);
    }

    private void printWinningStatisticsDetails(StringBuilder builder, PrizeMoney prizeMoney,
        Integer result, int i) {
        builder.append(prizeMoney.getMatchingCount());
        if (i == WIN_WITH_BONUS_NUMBER) {
            builder.append(OutputMessage.MATCH_COUNT_BONUS.getMessage());
        }
        if (i != WIN_WITH_BONUS_NUMBER) {
            builder.append(OutputMessage.MATCH_COUNT.getMessage());
        }
        builder.append(prizeMoney.getPrizeMoney())
            .append(OutputMessage.WON.getMessage())
            .append(result)
            .append(OutputMessage.COUNT.getMessage());
    }

    public void printTotalEarningsRate(float totalEarningsRate) {
        System.out.println(
            OutputMessage.TOTAL_EARNINGS_RATE.getMessage() + String.format(LIMIT_OF_DECIMAL_PLACE,
                totalEarningsRate)
                + OutputMessage.CLOSING_MENTION.getMessage());
    }
}
