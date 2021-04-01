package domain.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.value.validator.PurchasePriceValidator;
import ui.message.ExceptionMessage;

class PurchasePriceValidatorTest {
    private PurchasePriceValidator purchasePriceValidator;

    @BeforeEach
    void setUp() {
        purchasePriceValidator = new PurchasePriceValidator();
    }

    @Test
    public void 최소_입력값을_만족하는지_검증한다() {
        //given
        int purchasePrice = 60;

        //then
        Assertions.assertThatThrownBy(() -> purchasePriceValidator.validateSmallerThanPurchasePrice(purchasePrice))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.MUST_BUY_MORE_THAN_ONE_TICKET.getMessage());
    }
}