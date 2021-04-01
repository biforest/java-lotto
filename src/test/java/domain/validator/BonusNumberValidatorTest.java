package domain.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.value.WinningNumbers;
import domain.value.validator.BonusNumberValidator;
import ui.message.ExceptionMessage;

public class BonusNumberValidatorTest {
    private BonusNumberValidator bonusNumberValidator;

    @BeforeEach
    void setUp() {
        bonusNumberValidator = new BonusNumberValidator();
    }

    @Test
    public void 범위_초과하는_수를_검증한다() {
        //given
        int bonusNumber = 46;

        //then
        Assertions.assertThatThrownBy(() -> bonusNumberValidator.validateRangeOfBonusNumber(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
    }

    @Test
    public void 중복을_검사한다() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        int bonusNumber = 6;

        //then
        Assertions.assertThatThrownBy(() -> bonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.BONUS_NUMBER_CANNOT_EQUAL_WINNING_NUMBERS.getMessage());
    }
}
