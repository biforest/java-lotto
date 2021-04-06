package domain.value;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import ui.message.ExceptionMessage;

public class BonusNumberTest {
    @Test
    public void 범위_초과하는_수를_검증한다() {
        //given
        int bonusNumber = 46;
        ManualNumbersGenerator winningNumbers = new ManualNumbersGenerator("1, 2, 3, 4, 5, 6");

        //then
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
    }

    @Test
    public void 중복을_검사한다() {
        //given
        int bonusNumber = 6;
        ManualNumbersGenerator winningNumbers = new ManualNumbersGenerator("1, 2, 3, 4, 5, 6");

        //then
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.BONUS_NUMBER_CANNOT_EQUAL_WINNING_NUMBERS.getMessage());
    }
}
