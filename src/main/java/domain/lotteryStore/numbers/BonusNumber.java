package domain.lotteryStore.numbers;

import ui.message.ExceptionMessage;

public class BonusNumber extends LotteryNumberRange {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber, Lottery winningNumbers) {
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(int bonusNumber, Lottery winningNumbers) {
        return new BonusNumber(bonusNumber, winningNumbers);
    }

    private void validateDuplicate(int bonusNumber, Lottery winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                ExceptionMessage.BONUS_NUMBER_CANNOT_EQUAL_WINNING_NUMBERS.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
