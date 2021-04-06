package domain.lotteryStore.numbers;

import ui.message.ExceptionMessage;

public class LotteryNumberRange {
    public static final int MINIMUM_LOTTERY_NUMBER = 1;
    public static final int MAXIMUM_LOTTERY_NUMBER = 45;

    public void validateRange(int number) {
        if (!isInValidRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
        }
    }

    private boolean isInValidRange(Integer number) {
        return number >= MINIMUM_LOTTERY_NUMBER && number <= MAXIMUM_LOTTERY_NUMBER;
    }
}
