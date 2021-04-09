package lotto.domain;


public class PurchaseAmount {
    private static final int MIN_PURCHASE_AMOUNT = 0;

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        checkPurchaseAmountNotPositive(purchaseAmount);
    }

    private void checkPurchaseAmountNotPositive(int purchaseAmount) {
        if (purchaseAmount <= MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("구매 금액은 0원 이하가 될 수 없습니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
