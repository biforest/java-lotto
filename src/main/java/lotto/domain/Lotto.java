package lotto.domain;

import lotto.domain.validation.LottoValidation;

import java.util.List;

abstract class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        LottoValidation lottoValidation = new LottoValidation();
        lottoValidation.checkLottoLength(numbers);
        lottoValidation.checkDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public abstract List<Integer> getLotto();
}
