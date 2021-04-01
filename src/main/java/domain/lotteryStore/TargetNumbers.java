package domain.lotteryStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TargetNumbers {
    private final List<Integer> targetNumbers = new ArrayList<>();

    public TargetNumbers() {
        initiateNumbers();
    }

    private void initiateNumbers() {
        for (int i = 1; i <= 45; i++) {
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
