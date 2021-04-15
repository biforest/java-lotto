package domain.value;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.lotteryStore.numbers.ManualNumbersGenerator;
import ui.message.ExceptionMessage;

class ManualNumbersGeneratorTest {
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "3 2 ; 3", "#0, 3"})
    public void 숫자와_콤마_이외의_값을_검증한다(String invalidInput) {
        Assertions.assertThatThrownBy(() -> ManualNumbersGenerator.createManualLotteryNumbers(invalidInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.INPUT_ONLY_NUMBERS_AND_COMMA.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4", "1, 2, 3,", "1, 2", "1", "1, 2, 3, 4, 5, 6, 7"})
    public void 당첨번호_갯수를_검증한다(String invalidInput) {
        Assertions.assertThatThrownBy(() -> ManualNumbersGenerator.createManualLotteryNumbers(invalidInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.MUST_INPUT_SIX_WINNING_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 3, 4, 5, 6", "42, 1,34, 26,34, 19"})
    public void 중복_입력된_수를_검증한다(String invalidInput) {
        Assertions.assertThatThrownBy(() -> ManualNumbersGenerator.createManualLotteryNumbers(invalidInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.DUPLICATE_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 67, 6", "2, 1, 0, 26, 34, 19"})
    public void 입력_범위안에_들어오는지_검증한다(String invalidInput) {
        Assertions.assertThatThrownBy(() -> ManualNumbersGenerator.createManualLotteryNumbers(invalidInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
    }
}
