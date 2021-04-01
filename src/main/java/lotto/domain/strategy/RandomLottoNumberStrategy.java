package lotto.domain.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomLottoNumberStrategy {
    private final static int UPPER_BOUND = 45;
    private final static int LOWER_BOUND = 1;
    private final static int LOTTO_NUMBER_COUNT = 6;

    public List<Integer> getRandomLottoNumbers(){
        List<Integer> lottoNumberRange = setLottoNumberRange();
        return getLottoNumbers(lottoNumberRange);
    }

    private List<Integer> setLottoNumberRange(){
        ArrayList<Integer> lottoNumberIndex = new ArrayList<>();
        for (int lottoNumber = LOWER_BOUND; lottoNumber < UPPER_BOUND; lottoNumber++) {
            lottoNumberIndex.add(lottoNumber);
        }
        return lottoNumberIndex;
    }

    private List<Integer> getLottoNumbers(List<Integer> lottoNumberRange){
        Collections.shuffle(lottoNumberRange);
        return lottoNumberRange.subList(0,LOTTO_NUMBER_COUNT);
    }

}
