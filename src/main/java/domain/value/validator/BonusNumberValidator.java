package domain.value.validator;

import domain.value.WinningNumbers;
import ui.message.ExceptionMessage;

public class BonusNumberValidator {
    public void validateRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber < WinningNumbersValidator.MINIMUM_WINNING_NUMBER
            || bonusNumber > WinningNumbersValidator.MAXIMUM_WINNING_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
        }
    }

    public void validateBonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                ExceptionMessage.BONUS_NUMBER_CANNOT_EQUAL_WINNING_NUMBERS.getMessage());
        }
    }
}
