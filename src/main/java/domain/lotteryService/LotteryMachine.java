package domain.lotteryService;

import java.util.ArrayList;
import java.util.List;

import domain.lotteryStore.Lotteries;
import domain.lotteryStore.Lottery;
import domain.prize.Result;
import domain.prize.Results;

public class LotteryMachine {
    private static final int SIZE_OF_WINNING_NUMBERS = 6;

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LotteryMachine(String winningNumbers, int bonusNumber) {
        this.winningNumbers = new WinningNumbers(winningNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public Results compareNumbers(Lotteries lotteries, int purchasedCount) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < purchasedCount; i++) {
            results.add(compareOneTicketNumbers(lotteries.get(i)));
        }

        return new Results(results);
    }

    private Result compareOneTicketNumbers(Lottery lottery) {
        int matchingCount = 0;
        boolean hasBonusNumber;

        for (int i = 0; i < SIZE_OF_WINNING_NUMBERS; i++) {
            matchingCount += matchWinningNumbers(lottery, i);
        }
        hasBonusNumber = hasBonusNumber(lottery);

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
