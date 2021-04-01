package domain.validator;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.value.validator.WinningNumbersValidator;
import ui.message.ExceptionMessage;

public class WinningNumbersValidatorTest {
    private WinningNumbersValidator winningNumbersValidator;

    @BeforeEach
    void setUp() {
        winningNumbersValidator = new WinningNumbersValidator();
    }

    @Test
    public void 숫자와_콤마_이외의_값을_검증한다() {
        //given
        String input = "Hello";

        //then
        Assertions.assertThatThrownBy(() -> winningNumbersValidator.validateOtherCharacterSymbols(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.INPUT_ONLY_NUMBERS_AND_COMMA.getMessage());
    }

    @Test
    public void 당첨번호_갯수를_검증한다() {
        //given
        List<Integer> splitWinningNumbers = new ArrayList<>();
        splitWinningNumbers.add(1);
        splitWinningNumbers.add(2);
        splitWinningNumbers.add(3);
        splitWinningNumbers.add(4);
        splitWinningNumbers.add(5);

        //then
        Assertions.assertThatThrownBy(() -> winningNumbersValidator.validateSizeOfWinningNumbers(splitWinningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.MUST_INPUT_SIX_WINNING_NUMBERS.getMessage());
    }

    @Test
    public void 입력_범위안에_들어오는지_검증한다() {
        //given
        List<Integer> splitWinningNumbers = new ArrayList<>();
        splitWinningNumbers.add(46);
        splitWinningNumbers.add(2);
        splitWinningNumbers.add(3);
        splitWinningNumbers.add(4);
        splitWinningNumbers.add(5);
        splitWinningNumbers.add(6);

        //then
        Assertions.assertThatThrownBy(() -> winningNumbersValidator.validateRangeOfWinningNumbers(splitWinningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
    }

    @Test
    public void 중복_입력된_수를_검증한다() {
        //given
        List<Integer> splitWinningNumbers = new ArrayList<>();
        splitWinningNumbers.add(1);
        splitWinningNumbers.add(1);
        splitWinningNumbers.add(3);
        splitWinningNumbers.add(4);
        splitWinningNumbers.add(5);
        splitWinningNumbers.add(6);

        //then
        Assertions.assertThatThrownBy(
            () -> winningNumbersValidator.validateDuplicateWinningNumbers(splitWinningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.DUPLICATE_NUMBERS.getMessage());
    }
}
