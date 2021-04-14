package domain.value;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.lotteryStore.PurchasePrice;
import ui.message.ExceptionMessage;

class PurchasePriceTest {
    @Test
    public void 최소_입력값을_만족하는지_검증한다() {
        //given
        int purchasePrice = 900;

        //then
        Assertions.assertThatThrownBy(() -> new PurchasePrice(purchasePrice))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.MUST_BUY_MORE_THAN_ONE_TICKET.getMessage());
    }
}