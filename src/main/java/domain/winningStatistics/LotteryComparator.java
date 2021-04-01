package domain.winningStatistics;

import domain.lotteryStore.Lotteries;
import domain.lotteryStore.Lottery;
import domain.value.BonusNumber;
import domain.value.WinningNumbers;

public class LotteryComparator {
    private final WinningStatistics winningStatistics = new WinningStatistics();

    public void compareNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber, Lotteries lotteries,
        int purchasedCount) {
        for (int i = 0; i < purchasedCount; i++) {
            ComparisonResult comparisonResult = compareOneTicketNumbers(winningNumbers, bonusNumber, lotteries.get(i));
            winningStatistics.checkRanking(comparisonResult);
        }
    }

    public ComparisonResult compareOneTicketNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber,
        Lottery lottery) {
        return new ComparisonResult(getCountOfMatchingWinningNumbers(lottery, winningNumbers),
            hasBonusNumber(lottery, bonusNumber));
    }

    private int getCountOfMatchingWinningNumbers(Lottery lottery, WinningNumbers winningNumbers) {
        return lottery.getNumbers().countMatchingNumbers(winningNumbers);
    }

    private boolean hasBonusNumber(Lottery lottery, BonusNumber bonusNumber) {
        return lottery.getNumbers().contains(bonusNumber.getBonusNumber());
    }

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }
}
