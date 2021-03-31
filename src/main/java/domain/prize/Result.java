package domain.prize;

public class Result {
    private final int matchingCount;
    private final boolean havingBonusNumber;

    public Result(int matchingCount, boolean havingBonusNumber) {
        this.matchingCount = matchingCount;
        this.havingBonusNumber = havingBonusNumber;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isHavingBonusNumber() {
        return havingBonusNumber;
    }
}
