package domain.winningStatistics;

import domain.lotteryStore.Lotteries;
import domain.lotteryStore.Lottery;
import domain.lotteryStore.numbers.BonusNumber;
import domain.lotteryStore.numbers.ManualNumbersGenerator;

public class LotteryComparator {
    private final WinningStatistics winningStatistics = new WinningStatistics();

    public void compareNumbers(ManualNumbersGenerator winningNumbers, BonusNumber bonusNumber, Lotteries lotteries) {
        for (int i = 0; i < lotteries.size(); i++) {
            ComparisonResult comparisonResult = compareOneTicketNumbers(winningNumbers, bonusNumber, lotteries.get(i));
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

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }
}
