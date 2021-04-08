package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketOfNumberTest {
    @Test
    void 로또_티켓_수를_관리하는_객체를_생성한다() {
        //given
        int purchaseAmountNumber = 11000;
        int actual = 11;
        LottoTicketOfNumber lottoTicketOfNumber = new LottoTicketOfNumber(purchaseAmountNumber);

        //when
        int expected = lottoTicketOfNumber.getLottoTicketOfNumber();
        System.out.println(expected);

        //then
        assertThat(expected).isEqualTo(actual);
    }
}