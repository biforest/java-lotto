package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseAmountTest {

    @Test
    void 로또_구입금액_객체를_생성한다(){
        //given
        int purchaseAmountNumber = 1000;
        int actual = 1000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseAmountNumber);

        //when
        int expected = purchaseAmount.getPurchaseAmount();
        System.out.println(expected);

        //then
        assertThat(expected).isEqualTo(actual);
    }

    @ParameterizedTest(name = "{0}이 들어올때 예외 발생")
    @ValueSource(ints = {-1000, 0})
    void 로또_구입_금액이_0이하일_경우_IllegalArgumentException_을_던진다(int value) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(value));
    }
}