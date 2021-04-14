package lotto.domain;

import lotto.domain.lotto.AutoIssueStrategy;
import lotto.domain.lotto.Issuer;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PurchaseAmountTest {

    @Test
    void issueLottoTickets() {
        //given
        int money = 10000;
        int expected = 10;

        //when
        PurchaseAmount purchaseAmount = new PurchaseAmount(money, 0);
        LottoTickets lottoTickets = Issuer.issueLottoTickets(new AutoIssueStrategy(purchaseAmount.getNumberOfAutos()));

        //then
        int actual = lottoTickets.getLottoTickets().size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void moneyNotUnitOfLottoPrice() {
        //given
        int money = 14500;
        int expected = 14;

        //when
        PurchaseAmount purchaseAmount = new PurchaseAmount(money, 0);
        LottoTickets lottoTickets = Issuer.issueLottoTickets(new AutoIssueStrategy(purchaseAmount.getNumberOfAutos()));

        //then
        int actual = lottoTickets.getLottoTickets().size();
        assertThat(actual).isEqualTo(expected);
    }

    @ValueSource(ints = {999, 0, -1000})
    @ParameterizedTest
    void invalidMoney(int money) {
        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PurchaseAmount(money, 0))
                .withMessage("금액은 1000원 이상으로 입력해주세요.");
    }

    @DisplayName("수동 구매 금액이 전체 금액보다 많으면 예외")
    @Test
    void manualOverPurchaseAmount() {
        //given
        int purchaseAmount = 10000;
        int numberOfManuals = 12;

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PurchaseAmount(purchaseAmount, numberOfManuals))
                .withMessage("전체 금액보다 큰 숫자만큼 수동으로 구매할 수 없습니다.");
     }
}