package domain.lottowinningresult;

import java.util.List;

public class LottoWinningResult {
    private final List<Integer> lottoWinning;
    public LottoWinningResult(List<Integer> lottoWinning) {
        this.lottoWinning = lottoWinning;
    }

    public List<Integer> getLottoWinningResult() {
        return this.lottoWinning;

    }
}
