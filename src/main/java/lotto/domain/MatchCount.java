package lotto.domain;

public class MatchCount {

    private final int matchCount;
    private final boolean isBonusMatch;

    public MatchCount(int matchCount, boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
    }

    public boolean isUnderThree() {
        return matchCount < 3;
    }

    public boolean isMatchThree() {
        return matchCount == 3;
    }

    public boolean isMatchFour() {
        return matchCount == 4;
    }

    public boolean isMatchFiveWithoutBonus() {
        return matchCount == 5 && !isBonusMatch;
    }

    public boolean isMatchFiveWithBonus() {
        return matchCount == 5 && isBonusMatch;
    }

    public boolean isAllMatch() {
        return matchCount == 6;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }
}
