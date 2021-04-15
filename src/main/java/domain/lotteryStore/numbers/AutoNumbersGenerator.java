package domain.lotteryStore.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoNumbersGenerator {
    private static final List<Integer> autoNumbers = new ArrayList<>();

    static {
        IntStream.rangeClosed(LotteryNumberRange.MINIMUM_LOTTERY_NUMBER, LotteryNumberRange.MAXIMUM_LOTTERY_NUMBER)
            .forEach(autoNumbers::add);
    }

    public static List<Integer> createAutoLotteryNumbers() {
        shuffle();
        return autoNumbers.stream()
            .limit(6)
            .collect(Collectors.toList());
    }

    private static void shuffle() {
        Collections.shuffle(autoNumbers);
    }
}
