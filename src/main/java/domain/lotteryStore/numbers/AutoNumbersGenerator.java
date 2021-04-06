package domain.lotteryStore.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoNumbersGenerator {
    private final List<Integer> autoNumbers = new ArrayList<>();

    public AutoNumbersGenerator() {
        initiateNumbers();
    }

    private void initiateNumbers() {
        for (int i = LotteryNumberRange.MINIMUM_LOTTERY_NUMBER; i <= LotteryNumberRange.MAXIMUM_LOTTERY_NUMBER; i++) {
            autoNumbers.add(i);
        }
    }

    public void shuffle() {
        Collections.shuffle(autoNumbers);
    }

    public List<Integer> getSixNumbersFromTheFront() {
        return autoNumbers.stream()
            .limit(6)
            .collect(Collectors.toList());
    }
}
