package domain.value;

import domain.value.validator.PurchasePriceValidator;

public class PurchasePrice {
    private final int purchasePrice;
    private final PurchasePriceValidator purchasePriceValidator;

    public PurchasePrice(int purchasePrice) {
        purchasePriceValidator = new PurchasePriceValidator();
        purchasePriceValidator.validateSmallerThanPurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
