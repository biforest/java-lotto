package lotto.domain.lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    @Test
    void numberOfLottoNumbers() {
        //given
        int expected = 6;
        //when
        LottoTicket lottoTicket = new LottoTicket();
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        int actual = lottoNumbers.size();
        //then
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void rangeOfLottoNumbers() {
        //given
        final int UPPER_BOUND = 45;
        final int LOWER_BOUND = 1;
        //when
        LottoTicket lottoTicket = new LottoTicket();
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        //then
        lottoNumbers.forEach(
                lottoNumber -> assertThat(lottoNumber.getLottoNumber())
                        .isGreaterThanOrEqualTo(LOWER_BOUND)
                        .isLessThanOrEqualTo(UPPER_BOUND)
        );
    }
}