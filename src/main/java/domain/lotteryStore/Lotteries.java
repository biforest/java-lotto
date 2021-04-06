package domain.lotteryStore;

import java.util.List;

import domain.lotteryStore.numbers.BonusNumber;
import domain.lotteryStore.numbers.ManualNumbersGenerator;
import domain.winningStatistics.ComparisonResult;
import domain.winningStatistics.WinningStatistics;

public class Lotteries {
    private final List<Lottery> lotteries;
    private final WinningStatistics winningStatistics = new WinningStatistics();

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public void compareWithWinningNumbersAndBonusNumber(ManualNumbersGenerator winningNumbers,
        BonusNumber bonusNumber) {
        for (Lottery lottery : lotteries) {
            ComparisonResult comparisonResult = compareOneTicketNumbers(winningNumbers, bonusNumber, lottery);
            winningStatistics.checkRanking(comparisonResult);
        }
    }

    public ComparisonResult compareOneTicketNumbers(ManualNumbersGenerator winningNumbers, BonusNumber bonusNumber,
        Lottery lottery) {
        int countOfMatchingNumbers = getCountOfMatchingWinningNumbers(lottery, winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(lottery, bonusNumber);
        return new ComparisonResult(countOfMatchingNumbers, hasBonusNumber);
    }

    private int getCountOfMatchingWinningNumbers(Lottery lottery, ManualNumbersGenerator winningNumbers) {
        return lottery.getNumbers().countMatchingNumbers(winningNumbers);
    }

    private boolean hasBonusNumber(Lottery lottery, BonusNumber bonusNumber) {
        return lottery.getNumbers().contains(bonusNumber.getBonusNumber());
    }

    public Lottery get(int index) {
        return lotteries.get(index);
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }
}
