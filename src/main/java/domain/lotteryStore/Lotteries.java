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
            ComparisonResult comparisonResult = compareOneTicketNumbers(winningNumbers, bonusNumber, lottery);
            comparisonResult.rank(winningStatistics);
        }

        return winningStatistics;
    }

    public ComparisonResult compareOneTicketNumbers(Lottery winningNumbers, BonusNumber bonusNumber, Lottery lottery) {
        int countOfMatchingNumbers = getCountOfMatchingWinningNumbers(lottery, winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(lottery, bonusNumber);
        return ComparisonResult.of(countOfMatchingNumbers, hasBonusNumber);
    }

    private int getCountOfMatchingWinningNumbers(Lottery lottery, Lottery winningNumbers) {
        return lottery.countMatchingNumbers(winningNumbers);
    }

    private boolean hasBonusNumber(Lottery lottery, BonusNumber bonusNumber) {
        return lottery.contains(bonusNumber.getBonusNumber());
    }

    public Lottery get(int index) {
        return lotteries.get(index);
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }
}
