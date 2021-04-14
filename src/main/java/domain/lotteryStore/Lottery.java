package domain.lotteryStore;

import domain.lotteryStore.numbers.BonusNumber;
import domain.lotteryStore.numbers.ManualNumbersGenerator;
import domain.lotteryStore.numbers.Numbers;

public class Lottery {
    private final Numbers numbers;

    public Lottery(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public int getCountOfMatchingWinningNumbers(ManualNumbersGenerator winningNumbers) {
        return numbers.countMatchingNumbers(winningNumbers);
    }

    public boolean hasBonusNumber(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }
}
