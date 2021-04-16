package domain.value;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.lotteryStore.numbers.LotteryNumber;
import ui.message.ExceptionMessage;

class LotteryNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void 입력_범위안에_들어오는지_검증한다(int invalidNumber) {
        Assertions.assertThatThrownBy(() -> LotteryNumber.from(invalidNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
    }
}
