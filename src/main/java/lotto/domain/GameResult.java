package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum GameResult {

    UNDER_THREE_MATCHED(MatchCount::isUnderThree, 0),
    THREE_MATCHED(MatchCount::isMatchThree, 5_000),
    FOUR_MATCHED(MatchCount::isMatchFour, 50_000),
    FIVE_MATCHED_WITHOUT_BONUS(MatchCount::isMatchFiveWithoutBonus, 1_500_000),
    FIVE_MATCHED_WITH_BONUS(MatchCount::isMatchFiveWithBonus, 30_000_000),
    ALL_MATCHED(MatchCount::isAllMatch, 2_000_000_000);

    private static final String UNSUPPORTED_MATCH_COUNT_EXCEPTION_MESSAGE = "일치하는 게임 결과가 없습니다.";

    private final Predicate<MatchCount> matchPredicate;
    private final int prize;

    GameResult(Predicate<MatchCount> matchPredicate, int prize) {
        this.matchPredicate = matchPredicate;
        this.prize = prize;
    }

    public static GameResult evaluate(MatchCount matchCount) {
        return Arrays.stream(GameResult.values())
                .filter(gameResult -> gameResult.matchPredicate.test(matchCount))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(UNSUPPORTED_MATCH_COUNT_EXCEPTION_MESSAGE));
    }
}
