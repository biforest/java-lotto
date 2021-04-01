package lotto.domain;

import lotto.domain.lottowinningresult.LottoWinningBonusBallResult;
import lotto.domain.lottowinningresult.LottoWinningResult;

public class LottoFactory {
    private LottoWinningResult lottoWinningResult;
    private LottoWinningBonusBallResult lottoWinningBonusBallResult;

    public LottoFactory(LottoWinningResult lottoWinningResults, LottoWinningBonusBallResult lottoWinningBonusBallResults){
        this.lottoWinningResult = lottoWinningResults;
        this.lottoWinningBonusBallResult = lottoWinningBonusBallResults;
    }

}
