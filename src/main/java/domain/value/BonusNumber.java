package domain.value;

import domain.value.validator.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;
    private final BonusNumberValidator validator;

    public BonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
        validator = new BonusNumberValidator();
        validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
        validator.validateRangeOfBonusNumber(bonusNumber);
        validator.validateBonusNumber(bonusNumber, winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
