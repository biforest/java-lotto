package lotto.validation;

public class PurchaseAmountValidation {
    private static final int MIN_PURCHASE_AMOUNT = 0;

    public void checkPurchaseAmountNotPositive(int purchaseAmount) {
        if (purchaseAmount <= MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("구매 금액은 0원 이하가 될 수 없습니다.");
        }
    }

}
