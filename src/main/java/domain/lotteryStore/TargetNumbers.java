package domain.lotteryStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TargetNumbers {
    private final List<Integer> targetNumbers = new ArrayList<>();

    public TargetNumbers() {
        initNumbers();
    }

    private void initNumbers() {
        for (int i = 1; i <= 45; i++) {
            targetNumbers.add(i);
        }
    }

    public void shuffle() {
        Collections.shuffle(targetNumbers);
    }

    public List<Integer> getTargetNumbers() {
        return targetNumbers;
    }
}
