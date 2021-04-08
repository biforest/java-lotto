package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator {
    private final static int UPPER_BOUND = 45;
    private final static int LOWER_BOUND = 1;
    private final static int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> lottoNumberRange;

    public RandomLottoNumberGenerator() {
        lottoNumberRange = new ArrayList<>();
        setLottoNumberRange();
    }

    public List<Integer> getRandomLottoNumbers(){
        return getLottoNumbers(lottoNumberRange);
    }

    private void setLottoNumberRange(){
        for (int lottoNumber = LOWER_BOUND; lottoNumber < UPPER_BOUND; lottoNumber++) {
            lottoNumberRange.add(lottoNumber);
        }
    }

    private List<Integer> getLottoNumbers(List<Integer> lottoNumberRange){
        Collections.shuffle(lottoNumberRange);
        return lottoNumberRange.subList(0,LOTTO_NUMBER_COUNT);
    }

}
