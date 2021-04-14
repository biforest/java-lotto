package lotto.domain;

import lotto.domain.lotto.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningNumberTest {

    @DisplayName("보너스 번호는 당첨 번호에 포함되는 숫자여서는 안된다.")
    @Test
    void notWinningNumberContainsBonus() {
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 10, 30);
        int bonusNumber = 10;

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumber(lottoNumbers, bonusNumber))
                .withMessage("보너스 번호는 당첨 번호와 다른 번호여야 합니다.");
    }

}