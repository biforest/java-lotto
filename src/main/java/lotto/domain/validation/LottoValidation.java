package lotto.domain.validation;

import lotto.domain.exception.NotDuplicatedNumberException;
import lotto.domain.exception.NotValidLottoLengthException;

import java.util.ArrayList;
import java.util.List;

public class LottoValidation {
    private final static int LOTTO_NUMBER_COUNT = 6;

    public void checkLottoLength(List<Integer> numbers) {
        if(numbers.size() !=LOTTO_NUMBER_COUNT){
            throw new NotValidLottoLengthException();
        }
    }

    public void checkDuplicatedNumber(List<Integer> numbers) {
        List<Integer> duplicatedCheckNumbers = new ArrayList<>();
        for (Integer number :numbers) {
            hasDuplicatedNumber(number, duplicatedCheckNumbers);
        }
    }

    private void hasDuplicatedNumber(Integer number, List<Integer> numbers) {
        if(numbers.contains(number)) {
            throw new NotDuplicatedNumberException();
        }
        numbers.add(number);
    }
}
