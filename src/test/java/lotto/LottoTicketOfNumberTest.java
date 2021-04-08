package lotto;

import lotto.domain.NumberOfLottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.exception.NotValidLottoTicketOfNumberException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTicketOfNumberTest {
    @Test
    void 로또_티켓의_총_수를_관리하는_객체를_생성한다() {
        //given
        int totalPrice = 11000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(totalPrice);
        int manualLottoTicketOfNumber = 3;
        int actual = 11;
        NumberOfLottoTicket lottoTicketOfNumber = new NumberOfLottoTicket(purchaseAmount, manualLottoTicketOfNumber);

        //when
        int expected = lottoTicketOfNumber.getTotalNumberOfLottoTicket();
        System.out.println(expected);

        //then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void 자동_로또_티켓의_수를_가져온다() {
        //given
        int totalPrice = 11000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(totalPrice);
        int manualLottoTicketOfNumber = 3;
        int actual = 8;
        NumberOfLottoTicket lottoTicketOfNumber = new NumberOfLottoTicket(purchaseAmount, manualLottoTicketOfNumber);

        //when
        int expected = lottoTicketOfNumber.getAutomaticLottoTicketOfNumber();
        System.out.println(expected);

        //then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void 입력한_로또_구입_금액으로_로또를_살_수_없는_경우_NotValidLottoTicketOfNumberException_을_던진다() {
        //given
        int totalPrice = 900;
        PurchaseAmount purchaseAmount = new PurchaseAmount(totalPrice);
        int manualLottoTicketOfNumber = 3;
        //when
        //then
        assertThatExceptionOfType(NotValidLottoTicketOfNumberException.class).
                isThrownBy(() -> new NumberOfLottoTicket(purchaseAmount, manualLottoTicketOfNumber));
    }
}