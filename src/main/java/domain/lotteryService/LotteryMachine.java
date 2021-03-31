package domain.lotteryService;

import domain.lotteryStore.Lotteries;
import domain.lotteryStore.Lottery;
import domain.prize.Result;
import domain.prize.WinningStatistics;

public class LotteryMachine {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LotteryMachine(String winningNumbers, int bonusNumber) {
        // winningNumbers의 생성자에 bonusNumber를 넘겨주는 것은 좋지 않다고 생각하지만 그럼 어디서 validate?
        this.winningNumbers = new WinningNumbers(winningNumbers, bonusNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public WinningStatistics compareNumbers(Lotteries lotteries, int purchasedCount) {
        return null;
    }

    private Result compareOneTicketNumbers(Lottery lottery) {
        int matchingCount = 0;
        boolean hasBonusNumber = false;

        for (int i = 0; i < 6; i++) {
            matchingCount += matchWinningNumbers(lottery, i);
            hasBonusNumber = hasBonusNumber(lottery);
        }

        return new Result(matchingCount, hasBonusNumber);
    }

    private int matchWinningNumbers(Lottery lottery, int i) {
        if (lottery.contains(winningNumbers.get(i))) {
            return 1;
        }
        return 0;
    }

    private boolean hasBonusNumber(Lottery lottery) {
        return lottery.contains(bonusNumber.getBonusNumber());
    }
}
