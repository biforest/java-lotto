package domain.value.validator;

import ui.message.ExceptionMessage;

public class PurchasePriceValidator {
    private static final int MINIMUM_PURCHASE_PRICE = 1000;

    public void validateSmallerThanPurchasePrice(int purchasePrice) {
        if (purchasePrice < MINIMUM_PURCHASE_PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_BUY_MORE_THAN_ONE_TICKET.getMessage());
        }
    }
}
