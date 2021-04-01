package lotto.domain;

import lotto.domain.exception.NotValidLottoLengthException;

import java.util.List;

public class Lotto {
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers ) {
        checkLottoLength(numbers);
        this.numbers = numbers;
    }

    private void checkLottoLength(List<Integer> numbers){
        if(numbers.size() !=LOTTO_NUMBER_COUNT){
            throw new NotValidLottoLengthException();
        }
    }

    public List<Integer> getLotto(){
        return this.numbers;
    }
}
