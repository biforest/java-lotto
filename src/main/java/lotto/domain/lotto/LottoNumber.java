package lotto.domain.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;

    private static final String LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE =
            "로또 번호는 " + LOTTO_NUMBER_LOWER_BOUND + " 이상, " + LOTTO_NUMBER_UPPER_BOUND + " 이하여야 합니다.";

    private static final Map<Integer, LottoNumber> numbers;

    static {
        numbers = new HashMap<>();
        IntStream.rangeClosed(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND)
                .forEach(number -> numbers.put(number, new LottoNumber(number)));
    }

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        validate(lottoNumber);
        return numbers.get(lottoNumber);
    }

    private static void validate(int lottoNumber) {
        if (!isInRange(lottoNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isInRange(int lottoNumber) {
        return lottoNumber >= LOTTO_NUMBER_LOWER_BOUND && lottoNumber <= LOTTO_NUMBER_UPPER_BOUND;
    }

    public static List<LottoNumber> range() {
        return IntStream.rangeClosed(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
