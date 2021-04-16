package domain.lotteryStore.numbers;

import ui.message.ExceptionMessage;

public class BonusNumber {
    private final LotteryNumber bonusNumber;

    private BonusNumber(int bonusNumber, Lottery winningNumbers) {
        this.bonusNumber = LotteryNumber.from(bonusNumber);
        validateDuplicate(winningNumbers);
    }

    public static BonusNumber of(int bonusNumber, Lottery winningNumbers) {
        return new BonusNumber(bonusNumber, winningNumbers);
    }

    private void validateDuplicate(Lottery winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                ExceptionMessage.BONUS_NUMBER_CANNOT_EQUAL_WINNING_NUMBERS.getMessage());
        }
    }

    public LotteryNumber getBonusNumber() {
        return bonusNumber;
    }
}
