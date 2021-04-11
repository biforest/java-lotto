package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final String PRINT_IF_NUMBER_IS_INVALID_NUMBER = "유효한 로또 번호가 아닙니다.";
    private static final Map<Integer, LottoNumber> MAPPING_BALL = new HashMap<>();

    private final int number;

    static {
        DisposeBall();
    }

    private static void DisposeBall() {
        for (int ballNumber = MINIMUM_LOTTO_NUMBER; ballNumber <= MAXIMUM_LOTTO_NUMBER; ballNumber++) {
            MAPPING_BALL.put(ballNumber, new LottoNumber(ballNumber));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (MAPPING_BALL.containsKey(number)) {
            return MAPPING_BALL.get(number);
        }
        throw new IllegalArgumentException(PRINT_IF_NUMBER_IS_INVALID_NUMBER);
    }

    public static List<LottoNumber> getBalls() {
        return new ArrayList<>(MAPPING_BALL.values());
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber ball = (LottoNumber) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}