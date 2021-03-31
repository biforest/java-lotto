package ui.receiver;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.lotteryService.WinningNumbers;
import ui.Message;

class InputValidatorTest {

    @Test
    public void 당첨번호_중복_입력을_검증한다() throws Exception {
        //given
        String input = "1, 6, 3, 4, 5, 6";
        WinningNumbers winningNumbers = new WinningNumbers(input);

        //then
        Assertions.assertThatThrownBy(() -> InputValidator.validateDuplicateWinningNumbers(winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.ExceptionMessage.DUPLICATE_NUMBERS.getMessage());
    }
}