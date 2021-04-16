package domain.lotteryStore.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoNumbersGenerator {
    private static final List<Integer> autoNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(LotteryNumber.MINIMUM_LOTTERY_NUMBER, LotteryNumber.MAXIMUM_LOTTERY_NUMBER)
            .forEach(autoNumbers::add);
    }

    public static List<LotteryNumber> createAutoLotteryNumbers(ShuffleStrategy strategy) {
        strategy.shuffle(autoNumbers);
        return autoNumbers.stream()
            .limit(6)
            .map(LotteryNumber::from)
            .collect(Collectors.toList());
    }
}
