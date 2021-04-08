package lotto;

import lotto.validation.PurchaseAmountValidation;

public class PurchaseAmount {
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
