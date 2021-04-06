package domain.value;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.lotteryStore.numbers.LotteryNumberRange;
import ui.message.ExceptionMessage;

class LotteryNumberRangeTest {
    private LotteryNumberRange lotteryNumberRange;

    @BeforeEach
    void setUp() {
        lotteryNumberRange = new LotteryNumberRange();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47, 52, 55})
    public void 입력_범위안에_들어오는지_검증한다(int invalidNumber) {
        Assertions.assertThatThrownBy(() -> lotteryNumberRange.validateRange(invalidNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
    }
}