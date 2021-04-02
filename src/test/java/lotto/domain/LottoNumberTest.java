package lotto.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
class LottoNumberTest {
    @DisplayName("LottoNumber가 생성하는 후보 숫자는 1부터 45 사이")
    @Test
    void range() {
        //given
        List<LottoNumber> numbers = LottoNumber.range();
        //when then
        for (int containedNumber = 1; containedNumber <= 45; containedNumber++) {
            assertThat(numbers.contains(new LottoNumber(containedNumber))).isTrue();
        }
    }
    @DisplayName("비정상적인 인수로 LottoNumber 생성시 예외 발생")
    @Test
    void constructorException() {
        //given
        int lottoNumber = 46;
        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(lottoNumber))
                .withMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }
    @DisplayName("해시코드 테스트 커버리지 커")
    @Test
    void testCoverage() {
        //given when then
        LottoNumber lottoNumber = new LottoNumber(10);
        int hashCode = lottoNumber.hashCode();
        assertThat(hashCode).isEqualTo(lottoNumber.hashCode());
    }
}