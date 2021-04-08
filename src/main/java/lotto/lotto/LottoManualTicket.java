package lotto.lotto;

import java.util.List;

public class LottoManualTicket extends Lotto{
    private final List<Integer> numbers;

    public LottoManualTicket(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto(){
        return numbers;
    }
}
