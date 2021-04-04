package domain.lotteryStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TargetNumbers {
    public static final int MINIMUM_LOTTERY_NUMBER = 1;
    public static final int MAXIMUM_LOTTERY_NUMBER = 45;

    private final List<Integer> targetNumbers = new ArrayList<>();

    public TargetNumbers() {
        initiateNumbers();
    }

    private void initiateNumbers() {
        for (int i = MINIMUM_LOTTERY_NUMBER; i <= MAXIMUM_LOTTERY_NUMBER; i++) {
            targetNumbers.add(i);
        }
    }

    public void shuffle() {
        Collections.shuffle(targetNumbers);
    }

    public List<Integer> getSixNumbersFromTheFront() {
        return targetNumbers.stream()
            .limit(6)
            .collect(Collectors.toList());
    }
}
