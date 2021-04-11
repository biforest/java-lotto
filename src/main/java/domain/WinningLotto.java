package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningLotto {

    private static final String PRINT_IF_BONUSBALL_SAME_WITH_WINNING_NUMBER = "보너스 볼은 당첨 번호 6개와 중복 될 수 없습니다.";

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusBall) {
        validateCheckBonusBallSameWithWinningNumber(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    private void validateCheckBonusBallSameWithWinningNumber(Lotto winningLotto, LottoNumber bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException(PRINT_IF_BONUSBALL_SAME_WITH_WINNING_NUMBER);
        }
    }

    public ProfitResult getResult(Lottos lottos) {
        Map<LottoRank, Integer> result = getInitialResult();
        for (Lotto lotto : lottos) {
            putLottoRankResult(result, lotto);
        }
        return new ProfitResult(new LottoResult(result), lottos.getCount());
    }

    private void putLottoRankResult(Map<LottoRank, Integer> result, Lotto lotto) {
        int matchCount = lotto.countCommonBalls(winningLotto);
        if (!LottoRank.isMatchedCount(matchCount)) {
            return;
        }
        LottoRank rank = getLottoRank(lotto, matchCount);
        result.put(rank, result.get(rank) + 1);
    }

    private LottoRank getLottoRank(Lotto lotto, int matchCount) {
        LottoRank rank = LottoRank.getRank(matchCount, lotto.contains(bonusBall));
        return rank;
    }

    private Map<LottoRank, Integer> getInitialResult() {
        Map<LottoRank, Integer> result = new LinkedHashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
        return result;
    }
}