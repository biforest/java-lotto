package domain;

import java.util.Objects;

public class Money {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String MONEY_EXCEPTION_MESSAGE = String.format("로또 구매를 위한 최소 금액은 %d원 입니다.", ONE_LOTTO_PRICE);

    private final int money;

    public Money(int money) {
        validatePositive(money);
        this.money = money;
    }

    private void validatePositive(int money) {
        if (money < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(MONEY_EXCEPTION_MESSAGE);
        }
    }

    public static Money getMoney(LottoCount lottoCount) {
        return lottoCount.getBuyMoney(ONE_LOTTO_PRICE);
    }

    public LottoCount getLottoCount(int manualLottoCount) {
        return new LottoCount(money / ONE_LOTTO_PRICE, manualLottoCount);
    }

    public int multiply(int count) {
        return money * count;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
