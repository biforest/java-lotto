package lotto.domain.factory;
import lotto.domain.factory.Issuer;
import lotto.domain.lotto.LottoTickets;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
class IssuerTest {
    @Test
    void issueLottoTickets() {
        //given
        int money = 10000;
        int manualTicketCount = 2;
        int expected = 8;
        //when
        LottoTickets lottoTickets = Issuer.issueLottoTickets(money, manualTicketCount);
        //then
        int actual = lottoTickets.getLottoTickets().size();
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void moneyNotUnitOfLottoPrice() {
        //given
        int money = 14500;
        int manualTicketCount = 2;
        int expected = 12;
        //when
        LottoTickets lottoTickets = Issuer.issueLottoTickets(money, manualTicketCount);
        //then
        int actual = lottoTickets.getLottoTickets().size();
        assertThat(actual).isEqualTo(expected);
    }
    @ValueSource(ints = {999, 0, -1000})
    @ParameterizedTest
    void invalidMoney(int money, int manualTicketCount) {
        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Issuer.issueLottoTickets(money, manualTicketCount))
                .withMessage("금액은 1000원 이상으로 입력해주세요.");
    }
}