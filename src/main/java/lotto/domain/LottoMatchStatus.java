package lotto.domain;

public class LottoMatchStatus {
    private final int matchedCount;
    private final Boolean hasBonusBall;

    public LottoMatchStatus(int matchedCount, Boolean hasBonusBall) {
        this.matchedCount = matchedCount;
        this.hasBonusBall = hasBonusBall;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public Boolean getHasBonusBall() {
        return hasBonusBall;
    }
}
