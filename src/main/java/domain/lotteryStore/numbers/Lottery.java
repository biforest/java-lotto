package domain.lotteryStore.numbers;

import java.util.List;

public class Lottery {
    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
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
