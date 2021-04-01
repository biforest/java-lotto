package domain.winningStatistics;

public class ComparisonResult {
    private final int matchingCount;
    private final boolean havingBonusNumber;

    public ComparisonResult(int matchingCount, boolean havingBonusNumber) {
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
