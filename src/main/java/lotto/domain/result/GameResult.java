package lotto.domain.result;

import lotto.domain.MatchCount;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum GameResult {

    UNDER_THREE_MATCHED(MatchCount::isUnderThree, "2개 이하 일치", 0),
    THREE_MATCHED(MatchCount::isMatchThree, "3개 일치", 5_000),
    FOUR_MATCHED(MatchCount::isMatchFour, "4개 일치", 50_000),
    FIVE_MATCHED_WITHOUT_BONUS(MatchCount::isMatchFiveWithoutBonus, "5개 일치", 1_500_000),
    FIVE_MATCHED_WITH_BONUS(MatchCount::isMatchFiveWithBonus, "5개 일치, 보너스 볼 일치", 30_000_000),
    ALL_MATCHED(MatchCount::isAllMatch, "6개 일치", 2_000_000_000);

    private static final String UNSUPPORTED_MATCH_COUNT_EXCEPTION_MESSAGE = "일치하는 게임 결과가 없습니다.";

    private final Predicate<MatchCount> matchPredicate;
    private final String description;
    private final int prize;

    GameResult(Predicate<MatchCount> matchPredicate, String description, int prize) {
        this.matchPredicate = matchPredicate;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }
}
