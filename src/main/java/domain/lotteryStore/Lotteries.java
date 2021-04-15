package domain.lotteryStore;

import java.util.List;

import domain.lotteryStore.numbers.BonusNumber;
import domain.lotteryStore.numbers.Lottery;
import domain.winningStatistics.ComparisonResult;
import domain.winningStatistics.WinningStatistics;

public class Lotteries {
    private final List<Lottery> lotteries;

    private Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries from(List<Lottery> lotteries) {
        return new Lotteries(lotteries);
    }

    public WinningStatistics compareWithWinningNumbersAndBonusNumber(Lottery winningNumbers, BonusNumber bonusNumber) {
        WinningStatistics winningStatistics = WinningStatistics.getInstance();
        for (Lottery lottery : lotteries) {
            ComparisonResult comparisonResult = lottery.compareOneTicketNumbers(winningNumbers, bonusNumber);
            comparisonResult.rank(winningStatistics);
        }

        return winningStatistics;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }
}
