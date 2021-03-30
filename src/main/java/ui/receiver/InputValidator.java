package ui.receiver;

import ui.Message;

public class InputValidator {
    public static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < 1000) {
            throw new IllegalArgumentException(Message.ExceptionMessage.MUST_BUY_MORE_THAN_ONE_TICKET.getMessage());
        }
    }
}
