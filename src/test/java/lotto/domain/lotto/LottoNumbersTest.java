package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumbers거Test {

    @DisplayName("각각 다른 로또 번호가 아니라면 예외")
    @Test
    void sameLottoNumber() {
        //given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(10));

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers(lottoNumbers))
                .withMessage("로또 번호는 각각 다른 숫자여야만 합니다.");
    }

    @DisplayName("6자리가 아닌 로또 번호라면 예외")
    @Test
    void not6LottoNumbers() {
        //given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(10), new LottoNumber(45));

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers(lottoNumbers))
                .withMessage("로또 번호는 6자리이어야 합니다.");
    }

}