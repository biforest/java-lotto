package domain.lotteryStore.numbers;

import java.util.Objects;

import ui.message.ExceptionMessage;

public class LotteryNumber {
    public static final int MINIMUM_LOTTERY_NUMBER = 1;
    public static final int MAXIMUM_LOTTERY_NUMBER = 45;

    private final int number;

    private LotteryNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public static LotteryNumber from(int number) {
        return new LotteryNumber(number);
    }

    private void validateRange(int number) {
        if (!isInValidRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
        }
    }

    private boolean isInValidRange(int number) {
        return number >= MINIMUM_LOTTERY_NUMBER && number <= MAXIMUM_LOTTERY_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LotteryNumber that = (LotteryNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
