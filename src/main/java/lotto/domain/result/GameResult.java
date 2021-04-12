package lotto.domain.result;

import lotto.domain.MatchCount;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum GameResult {

    UNDER_THREE_MATCHED(MatchCount::isUnderThree, new MatchCount(0, false), 0),
    THREE_MATCHED(MatchCount::isMatchThree, new MatchCount(3, false), 5_000),
    FOUR_MATCHED(MatchCount::isMatchFour, new MatchCount(4, false), 50_000),
    FIVE_MATCHED_WITHOUT_BONUS(MatchCount::isMatchFiveWithoutBonus, new MatchCount(5, false), 1_500_000),
    FIVE_MATCHED_WITH_BONUS(MatchCount::isMatchFiveWithBonus, new MatchCount(5, true), 30_000_000),
    ALL_MATCHED(MatchCount::isAllMatch, new MatchCount(6, false), 2_000_000_000);

    private static final String UNSUPPORTED_MATCH_COUNT_EXCEPTION_MESSAGE = "일치하는 게임 결과가 없습니다.";

    private final Predicate<MatchCount> matchPredicate;
    private final MatchCount matchCount;
    private final int prize;

    GameResult(Predicate<MatchCount> matchPredicate, MatchCount matchCount, int prize) {
        this.matchPredicate = matchPredicate;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static GameResult evaluate(MatchCount matchCount) {
        return Arrays.stream(GameResult.values())
                .filter(gameResult -> gameResult.matchPredicate.test(matchCount))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(UNSUPPORTED_MATCH_COUNT_EXCEPTION_MESSAGE));
    }

    public static List<GameResult> valuesWithoutUnderThreeMatched() {
        return Arrays.stream(GameResult.values())
                .filter(gameResult -> !gameResult.equals(GameResult.UNDER_THREE_MATCHED))
                .collect(Collectors.toList());
    }

    public int getPrize() {
        return prize;
    }

    public MatchCount getMatchCount() {
        return matchCount;
    }
}
