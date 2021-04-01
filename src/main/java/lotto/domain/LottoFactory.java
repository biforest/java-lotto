package lotto.domain;

import lotto.domain.lottowinningresult.LottoWinningBonusBallResult;
import lotto.domain.lottowinningresult.LottoWinningResult;

import java.util.ArrayList;
import java.util.Locale;


public class LottoFactory {
    private LottoWinningResult lottoWinningResult;
    private LottoWinningBonusBallResult lottoWinningBonusBallResult;

    public LottoFactory(LottoWinningResult lottoWinningResults, LottoWinningBonusBallResult lottoWinningBonusBallResults){
        this.lottoWinningResult = lottoWinningResults;
        this.lottoWinningBonusBallResult = lottoWinningBonusBallResults;
    }

}
