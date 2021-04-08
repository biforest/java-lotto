package lotto.domain;

import lotto.domain.validation.PurchaseAmountValidation;

public class PurchaseAmount {
    private static final int MIN_PURCHASE_AMOUNT = 0;

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        PurchaseAmountValidation purchaseAmountValidation = new PurchaseAmountValidation();
        this.purchaseAmount = purchaseAmount;
        purchaseAmountValidation.checkPurchaseAmountNotPositive(this.purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
