package domain.winningStatistics;

public class ComparisonResult {
    private final int matchingCount;
    private final boolean havingBonusNumber;

    public ComparisonResult(int matchingCount, boolean havingBonusNumber) {
        this.matchingCount = matchingCount;
        this.havingBonusNumber = havingBonusNumber;
    }

    public void checkRanking(WinningStatistics winningStatistics) {
        for (PrizeMoney prizeMoney : PrizeMoney.values()) {
            checkWinnings(winningStatistics, prizeMoney);
        }
    }

    private void checkWinnings(WinningStatistics winningStatistics, PrizeMoney prizeMoney) {
        if (prizeMoney.isSameMatchingCount(matchingCount)
                && isHavingBonusNumberWithFiveMatchingCount() == prizeMoney.isHavingBonusNumber()) {
            winningStatistics.increase(prizeMoney);
        }
    }

    private boolean isHavingBonusNumberWithFiveMatchingCount() {
        return matchingCount == 5 && havingBonusNumber;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isHavingBonusNumber() {
        return havingBonusNumber;
    }
}
