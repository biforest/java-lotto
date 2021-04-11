package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final String LOTTO_NUMBER_COUNT_EXCEPTION_MESSAGE = "6개를 입력해주세요";
    private static final String DELIMITER = ", ";
    private static final int NUMBER_COUNT_ZERO = 0;
    private static final int NUMBER_COUNT = 6;

    private final Set<LottoNumber> balls;

    private Lotto(Set<LottoNumber> balls) {
        validateBallCount(balls);
        this.balls = Collections.unmodifiableSet(new HashSet<>(balls));
    }

    private void validateBallCount(Set<LottoNumber> balls) {
        if (balls.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_EXCEPTION_MESSAGE);
        }
    }

    public static Lotto of(String rawLotto) {
        String[] numbers = rawLotto.split(DELIMITER);
        Set<LottoNumber> balls = new HashSet<>();
        for (String number : numbers) {
            balls.add(LottoNumber.of(Integer.parseInt(number)));
        }
        return new Lotto(balls);
    }

    public static Lotto newAutoLotto() {
        List<LottoNumber> balls = LottoNumber.getBalls();
        Collections.shuffle(balls);
        Set<LottoNumber> randomBalls = new HashSet<>(balls.subList(NUMBER_COUNT_ZERO, NUMBER_COUNT));
        return new Lotto(randomBalls);
    }

    public static boolean moreThanBallCount(int matchCount) {
        return matchCount > NUMBER_COUNT;
    }

    public boolean contains(LottoNumber ball) {
        return balls.contains(ball);
    }

    public int countCommonBalls(Lotto lotto) {
        Set<LottoNumber> sameBalls = new HashSet<>(balls);
        sameBalls.retainAll(lotto.balls);
        return sameBalls.size();
    }

    public List<String> getLotto() {
        List<String> ballsData = balls.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(ballsData);
    }
}