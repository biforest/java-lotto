package lotto.domain;

import lotto.domain.lotto.AutoIssueStrategy;
import lotto.domain.lotto.Issuer;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    private final LottoTicket lottoTicket;

    public LottoTicketTest() {
        lottoTicket = Issuer.issueLottoTickets(new AutoIssueStrategy(1)).getLottoTickets().get(0);
    }

    @Test
    void numberOfLottoNumbers() {
        //given
        int expected = 6;

        //when
        int actual = lottoTicket.getLottoNumbers().getLottoNumbers().size();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void rangeOfLottoNumbers() {
        //given
        final int UPPER_BOUND = 45;
        final int LOWER_BOUND = 1;

        //when=
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers().getLottoNumbers();

        //then
        lottoNumbers.forEach(
                lottoNumber -> assertThat(lottoNumber.getLottoNumber())
                        .isGreaterThanOrEqualTo(LOWER_BOUND)
                        .isLessThanOrEqualTo(UPPER_BOUND)
        );
    }
}