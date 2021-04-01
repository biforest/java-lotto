package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Lotto {
    private static final int RANDOM_LOTTO_NUMBER_COUNT = 6;
    private final Random random = new Random();
    private final List<Integer> lottoNumber;

    public Lotto(){
        this.lottoNumber = new ArrayList<>(generateRandomLottoNumber());

    }

    public List<Integer> generateRandomLottoNumber(){
        List<Integer> number;
        number = ThreadLocalRandom.current()
                .ints(1, 45)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toList());
        return number;
    }

    public List<Integer> getLottoNumber(){
        return lottoNumber;
    }
}
