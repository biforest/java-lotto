package lotto.domain.lottoticket;

import lotto.domain.exception.NotValidLottoLengthException;
import java.util.List;

public class LottoTicket implements Lotto{
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers ) {
        checkLottoLength(numbers);
        this.numbers = numbers;
    }

    private void checkLottoLength(List<Integer> numbers){
        if(numbers.size() !=LOTTO_NUMBER_COUNT){
            throw new NotValidLottoLengthException();
        }
    }
    @Override
    public List<Integer> getLotto(){
        return this.numbers;
    }
}