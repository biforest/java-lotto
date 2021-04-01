package domain.winningStatistics;

import java.util.List;

public class WinningStatistics {
    private static final int FIFTH_PLACE_INDEX = 0;
    private static final int FOURTH_PLACE_INDEX = 1;
    private static final int THIRD_PLACE_INDEX = 2;
    private static final int SECOND_PLACE_INDEX = 3;
    private static final int FIRST_PLACE_INDEX = 4;

    // 1~5등을 한 로또 티켓들이 각각 몇개인지
    private final Rankings rankings;

    public WinningStatistics() {
        rankings = new Rankings();
    }

    public void checkRanking(ComparisonResult comparisonResult) {
        findFifthPlaces(comparisonResult);
        findFourthPlaces(comparisonResult);
        findSecondOrThirdPlaces(comparisonResult);
        findFirstPlaces(comparisonResult);
    }

    private void findFifthPlaces(ComparisonResult comparisonResult) {
        if (comparisonResult.getMatchingCount() == PrizeMoney.THREE.getMatchingCount()) {
            rankings.increase(FIFTH_PLACE_INDEX);
        }
    }

    private void findFourthPlaces(ComparisonResult comparisonResult) {
        if (comparisonResult.getMatchingCount() == PrizeMoney.FOUR.getMatchingCount()) {
            rankings.increase(FOURTH_PLACE_INDEX);
        }
    }

    private void findSecondOrThirdPlaces(ComparisonResult comparisonResult) {
        if (comparisonResult.getMatchingCount() == PrizeMoney.FIVE.getMatchingCount()) {
            findLotteriesNotHavingBonusNumber(comparisonResult);
            findLotteriesHavingBonusNumber(comparisonResult);
        }
    }

    private void findLotteriesNotHavingBonusNumber(ComparisonResult comparisonResult) {
        if (!comparisonResult.isHavingBonusNumber()) {
            rankings.increase(THIRD_PLACE_INDEX);
        }
    }

    private void findLotteriesHavingBonusNumber(ComparisonResult comparisonResult) {
        if (comparisonResult.isHavingBonusNumber()) {
            rankings.increase(SECOND_PLACE_INDEX);
        }
    }

    private void findFirstPlaces(ComparisonResult comparisonResult) {
        if (comparisonResult.getMatchingCount() == PrizeMoney.SIX.getMatchingCount()) {
            rankings.increase(FIRST_PLACE_INDEX);
        }
    }

    public List<Integer> getRankings() {
        return rankings.getRankings();
    }
}
