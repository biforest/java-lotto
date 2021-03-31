package domain.lotteryStore;

public class Lottery {
    private final Numbers numbers;

    public Lottery(Numbers numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.getNumbers().contains(number);
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
