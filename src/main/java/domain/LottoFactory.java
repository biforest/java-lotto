package domain;

import domain.lottowinningresult.LottoWinningBonusBallResult;
import domain.lottowinningresult.LottoWinningResult;

public class LottoFactory {
    private LottoWinningResult lottoWinningResult;
    private LottoWinningBonusBallResult lottoWinningBonusBallResult;

    public LottoFactory(LottoWinningResult lottoWinningResults, LottoWinningBonusBallResult lottoWinningBonusBallResults){
        this.lottoWinningResult = lottoWinningResults;
        this.lottoWinningBonusBallResult = lottoWinningBonusBallResults;
    }

    public LottoWinningResult getLottoWinningResult(){
        return this.lottoWinningResult;
    }

    public LottoWinningBonusBallResult getLottoWinningBonusBallResult(){
        return this.lottoWinningBonusBallResult;
    }

}
