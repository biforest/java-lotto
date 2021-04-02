package lotto.domain.lotto;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class LottoNumber {
    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    private static final String LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE =
            "로또 번호는 " + LOTTO_NUMBER_LOWER_BOUND + " 이상, " + LOTTO_NUMBER_UPPER_BOUND + " 이하여야 합니다.";
    private final int lottoNumber;
    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }
    private void validate(int lottoNumber) {
        if (!isInRange(lottoNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }
    private boolean isInRange(int lottoNumber) {
        return lottoNumber >= LOTTO_NUMBER_LOWER_BOUND && lottoNumber <= LOTTO_NUMBER_UPPER_BOUND;
    }
    public static List<LottoNumber> range() {
        return IntStream.range(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND + 1)
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
}