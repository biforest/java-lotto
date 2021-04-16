package domain.lotteryStore.numbers;

import java.util.List;
import java.util.stream.Collectors;

import domain.winningStatistics.ComparisonResult;

public class Lottery {
    private final List<LotteryNumber> numbers;

    private Lottery(List<LotteryNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lottery from(List<LotteryNumber> numbers) {
        return new Lottery(numbers);
    }

    public ComparisonResult compareOneTicketNumbers(Lottery winningNumbers, BonusNumber bonusNumber) {
        int countOfMatchingNumbers = countMatchingNumbers(winningNumbers);
        boolean hasBonusNumber = contains(bonusNumber.getBonusNumber());
        return ComparisonResult.of(countOfMatchingNumbers, hasBonusNumber);
    }

    private int countMatchingNumbers(Lottery winningNumbers) {
        return (int)winningNumbers.getNumbers()
            .stream()
            .filter(this::contains)
            .count();
    }

    public boolean contains(LotteryNumber numberToCompare) {
        return numbers.contains(numberToCompare);
    }

    public List<LotteryNumber> getNumbers() {
        return numbers;
    }

    public List<Integer> getIntegerNumbers() {
        return numbers.stream()
            .map(LotteryNumber::getNumber)
            .collect(Collectors.toList());
    }
}
