package lotto.domain.lotto;

public class PurchaseAmount {

    private static final int TICKET_PRICE = 1000;

    private static final String MONEY_AMOUNT_EXCEPTION_MESSAGE = "금액은 " + TICKET_PRICE + "원 이상으로 입력해주세요.";
    private static final String NUMBER_OF_MANUALS_EXCEPTION_MESSAGE = "전체 금액보다 큰 숫자만큼 수동으로 구매할 수 없습니다.";

    private final int purchaseAmount;
    private final int numberOfPurchases;
    private final int numberOfManuals;

    public PurchaseAmount(int purchaseAmount, int numberOfManuals) {
        validate(purchaseAmount, numberOfManuals);
        this.purchaseAmount = purchaseAmount;
        this.numberOfPurchases = purchaseAmount / TICKET_PRICE;
        this.numberOfManuals = numberOfManuals;
    }

    private void validate(int purchaseAmount, int numberOfManuals) {
        if (purchaseAmount < TICKET_PRICE) {
            throw new IllegalArgumentException(MONEY_AMOUNT_EXCEPTION_MESSAGE);
        }

        int numberOfPurchases = purchaseAmount / TICKET_PRICE;
        if (numberOfPurchases < numberOfManuals) {
            throw new IllegalArgumentException(NUMBER_OF_MANUALS_EXCEPTION_MESSAGE);
        }
    }

    public int getNumberOfAutos() {
        return numberOfPurchases - numberOfManuals;
    }

    public int getNumberOfManuals() {
        return numberOfManuals;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
