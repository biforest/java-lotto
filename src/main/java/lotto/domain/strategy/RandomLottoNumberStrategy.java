package lotto.domain.strategy;

import java.util.Random;

public class RandomLottoNumberStrategy {
    private final static int UPPER_BOUND = 46;

    public int decideNumber(){
        return new Random().nextInt(UPPER_BOUND);
    }
}
