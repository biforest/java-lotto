package domain.winningStatistics;

public class ComparisonResult {
    private final int matchingCount;
    private final boolean havingBonusNumber;

    public ComparisonResult(int matchingCount, boolean havingBonusNumber) {
        this.matchingCount = matchingCount;
        this.havingBonusNumber = havingBonusNumber;
    }

    public void rank(WinningStatistics winningStatistics) {
        for (Ranking ranking : Ranking.values()) {
            checkWinnings(winningStatistics, ranking);
        }
    }

    private void checkWinnings(WinningStatistics winningStatistics, Ranking ranking) {
        if (isSecondPlace(ranking) || isThirdPlace(ranking) || isOtherRank(ranking)) {
            winningStatistics.win(ranking);
        }
    }

    private boolean isSecondPlace(Ranking ranking) {
        return hasFiveMatchingCount() && havingBonusNumber && ranking == Ranking.FIVE_BONUS;
    }

    private boolean isThirdPlace(Ranking ranking) {
        return hasFiveMatchingCount() && !havingBonusNumber && ranking == Ranking.FIVE;
    }

    private boolean isOtherRank(Ranking ranking) {
        return !hasFiveMatchingCount() && ranking.isSameMatchingCount(matchingCount);
    }

    private boolean hasFiveMatchingCount() {
        return matchingCount == 5;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isHavingBonusNumber() {
        return havingBonusNumber;
    }
}
