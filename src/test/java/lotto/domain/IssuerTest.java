package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class IssuerTest {

    @Test
    void issueLottos() {
        //given
        int money = 10000;
        int expected = 10;

        //when
        LottoTickets lottoTickets = Issuer.issueLottos(money);

        //then
        int actual = lottoTickets.getLottos().size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void moneyNotUnitOfLottoPrice() {
        //given
        int money = 14500;
        int expected = 14;

        //when
        LottoTickets lottoTickets = Issuer.issueLottos(money);

        //then
        int actual = lottoTickets.getLottos().size();
        assertThat(actual).isEqualTo(expected);
     }

    @ValueSource(ints = {999, 0, -1000})
    @ParameterizedTest
    void invalidMoney(int money) {
        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Issuer.issueLottos(money))
                .withMessage("금액은 1000원 이상으로 입력해주세요.");
     }
}