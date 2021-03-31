package domain.lotteryStore;

public class Lottery {
    private final Numbers numbers;

    public Lottery(Numbers numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int numberToCompare) {
        return numbers.getNumbers().contains(numberToCompare);
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
