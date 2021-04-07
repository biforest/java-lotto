package lotto.domain.lottowinningresult;

import java.util.List;

public class LottoWinningBonusBallResult {
    private final List<Boolean> LottoWinningBonusBall;

    public LottoWinningBonusBallResult(List<Boolean> LottoWinningBonusBall) {
        this.LottoWinningBonusBall = LottoWinningBonusBall;
    }

    public List<Boolean> getLottoWinningBonusBallResult(){
        return this.LottoWinningBonusBall;
    }
}
