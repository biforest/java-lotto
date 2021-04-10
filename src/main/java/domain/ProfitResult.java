package domain;

import java.util.Map;

public class ProfitResult {
    private static final int PROFIT_THRESHOLD = 1;

    private final LottoResult lottoResult;
    private final LottoCount count;

    public ProfitResult(LottoResult lottoResult, LottoCount count) {
        this.lottoResult = lottoResult;
        this.count = count;
    }

    public float getProfitRate() {
        float totalPrize = lottoResult.calculateTotalPrize();
        Money money = Money.getMoney(count);
        return totalPrize / money.getMoney();
    }

    public boolean isProfit() {
        if (getProfitRate() < PROFIT_THRESHOLD) {
            return false;
        }
        return true;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult.getRankResult();
    }
}