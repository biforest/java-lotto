package lotto.domain.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator {
    private final static int UPPER_BOUND = 45;
    private final static int LOWER_BOUND = 1;
    private final static int LOTTO_NUMBER_COUNT = 6;

    private List<Integer> setLottoNumberRange(){
        List<Integer> lottoNumberRange = new ArrayList<>();
        for (int lottoNumber = LOWER_BOUND; lottoNumber < UPPER_BOUND; lottoNumber++) {
            lottoNumberRange.add(lottoNumber);
        }
        return lottoNumberRange;
    }

    public List<Integer> getRandomLottoNumbers(){
        List<Integer> lottoNumberRange = setLottoNumberRange();
        Collections.shuffle(lottoNumberRange);
        List<Integer> collectedNumbers = lottoNumberRange.subList(0,LOTTO_NUMBER_COUNT);
        Collections.sort(collectedNumbers);
        return collectedNumbers;
    }

}
