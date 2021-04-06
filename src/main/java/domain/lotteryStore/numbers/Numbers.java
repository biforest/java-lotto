package domain.lotteryStore.numbers;

import java.util.Collections;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int countMatchingNumbers(ManualNumbersGenerator winningNumbers) {
        return (int)winningNumbers.getManualNumbers()
            .stream()
            .filter(this::contains)
            .count();
    }

    public boolean contains(int numberToCompare) {
        return numbers.contains(numberToCompare);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
