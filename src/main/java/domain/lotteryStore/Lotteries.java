package domain.lotteryStore;

import java.util.List;

import domain.lotteryStore.numbers.BonusNumber;
import domain.lotteryStore.numbers.ManualNumbersGenerator;
import domain.winningStatistics.ComparisonResult;
import domain.winningStatistics.WinningStatistics;

public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public WinningStatistics compareWithWinningNumbersAndBonusNumber(ManualNumbersGenerator winningNumbers,
        BonusNumber bonusNumber) {
        WinningStatistics winningStatistics = new WinningStatistics();
        for (Lottery lottery : lotteries) {
            ComparisonResult comparisonResult = compareOneTicketNumbers(winningNumbers, bonusNumber, lottery);
            comparisonResult.checkRanking(winningStatistics);
        }

        return winningStatistics;
    }

    public ComparisonResult compareOneTicketNumbers(ManualNumbersGenerator winningNumbers, BonusNumber bonusNumber,
        Lottery lottery) {
        int countOfMatchingNumbers = lottery.getCountOfMatchingWinningNumbers(winningNumbers);
        boolean hasBonusNumber = lottery.hasBonusNumber(bonusNumber);
        return new ComparisonResult(countOfMatchingNumbers, hasBonusNumber);
    }

    public Lottery get(int index) {
        return lotteries.get(index);
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }
}
