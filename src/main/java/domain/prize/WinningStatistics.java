package domain.prize;

import java.util.Arrays;
import java.util.List;

public class WinningStatistics {
    private static final int FIFTH_PLACE_INDEX = 0;
    private static final int FOURTH_PLACE_INDEX = 1;
    private static final int THIRD_PLACE_INDEX = 2;
    private static final int SECOND_PLACE_INDEX = 3;
    private static final int FIRST_PLACE_INDEX = 4;

    // 1~5등을 한 로또 티켓들이 각각 몇개인지
    private final Ranking rankings;

    public WinningStatistics(Results results) {
        rankings = new Ranking(Arrays.asList(0, 0, 0, 0, 0));
        findWinningLotteriesFromResults(results);
    }

    private void findWinningLotteriesFromResults(Results results) {
        for (Result result : results.getResults()) {
            findFifthPlaces(result);
            findFourthPlaces(result);
            findSecondAndThirdPlaces(result);
            findFirstPlaces(result);
        }
    }

    private void findFifthPlaces(Result result) {
        if (result.getMatchingCount() == PrizeMoney.THREE.getMatchingCount()) {
            rankings.increase(FIFTH_PLACE_INDEX);
        }
    }

    private void findFourthPlaces(Result result) {
        if (result.getMatchingCount() == PrizeMoney.FOUR.getMatchingCount()) {
            rankings.increase(FOURTH_PLACE_INDEX);
        }
    }

    private void findSecondAndThirdPlaces(Result result) {
        if (result.getMatchingCount() == PrizeMoney.FIVE.getMatchingCount()) {
            findLotteriesNotHavingBonusNumber(result);
            findLotteriesHavingBonusNumber(result);
        }
    }

    private void findLotteriesNotHavingBonusNumber(Result result) {
        if (!result.isHavingBonusNumber()) {
            rankings.increase(THIRD_PLACE_INDEX);
        }
    }

    private void findLotteriesHavingBonusNumber(Result result) {
        if (result.isHavingBonusNumber()) {
            rankings.increase(SECOND_PLACE_INDEX);
        }
    }

    private void findFirstPlaces(Result result) {
        if (result.getMatchingCount() == PrizeMoney.SIX.getMatchingCount()) {
            rankings.increase(FIRST_PLACE_INDEX);
        }
    }

    public List<Integer> getRankings() {
        return rankings.getSizeOfRanks();
    }
}
