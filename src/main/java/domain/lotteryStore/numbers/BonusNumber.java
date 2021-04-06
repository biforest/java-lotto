package domain.lotteryStore.numbers;

import ui.message.ExceptionMessage;

public class BonusNumber extends LotteryNumberRange {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, ManualNumbersGenerator winningNumbers) {
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public void validateDuplicate(int bonusNumber, ManualNumbersGenerator winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                ExceptionMessage.BONUS_NUMBER_CANNOT_EQUAL_WINNING_NUMBERS.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
