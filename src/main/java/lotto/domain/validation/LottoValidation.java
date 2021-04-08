package lotto.domain.validation;

import lotto.domain.exception.NotValidLottoLengthException;

import java.util.List;

public class LottoValidation {
    private final static int LOTTO_NUMBER_COUNT = 6;

    public void checkLottoLength(List<Integer> numbers){
        if(numbers.size() !=LOTTO_NUMBER_COUNT){
            throw new NotValidLottoLengthException();
        }
    }
}
