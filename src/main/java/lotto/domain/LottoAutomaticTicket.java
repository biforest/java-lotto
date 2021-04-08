package lotto.domain;

import java.util.List;

public class LottoAutomaticTicket extends Lotto{

    private final List<Integer> numbers;

    public LottoAutomaticTicket(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getLotto(){
        return this.numbers;
    }
}
