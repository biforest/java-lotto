package domain.lotteryStore;

import ui.message.ExceptionMessage;

public class PurchasePrice {
    public static final int PRICE_OF_ONE_LOTTERY_TICKET = 1000;

    private final int purchasePrice;

    private PurchasePrice(int purchasePrice) {
        validateSmallerThanPurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public static PurchasePrice from(int purchasePrice) {
        return new PurchasePrice(purchasePrice);
    }

    private void validateSmallerThanPurchasePrice(int purchasePrice) {
        if (purchasePrice < PRICE_OF_ONE_LOTTERY_TICKET) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_BUY_MORE_THAN_ONE_TICKET.getMessage());
        }
    }

    public int getPurchasedCount() {
        return purchasePrice / PRICE_OF_ONE_LOTTERY_TICKET;
    }
}
