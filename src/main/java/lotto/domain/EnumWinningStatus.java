package lotto.domain;

import lotto.domain.lottowinningresult.LottoWinningBonusBallResult;
import lotto.domain.lottowinningresult.LottoWinningResult;

import java.util.ArrayList;
import java.util.List;

public class EnumWinningStatus {
    private List<LottoFactory> lottoFactories;

    public List<Long> mappingMatchedLottoWithWinningMoney(LottoFactory lottoWinningResult){
        ArrayList<Long> mappingMatchedLottoWithWinningMoney = new ArrayList<>();

        for(WinningStatus winningStatus: WinningStatus.values()){
            long lottoWinningResultsCount = lottoFactories.stream().
                    filter(lottoMatchCount -> lottoMatchCount.equals(winningStatus.getMatchCount())).
                    filter(lottoMatchBonusBall -> (lottoMatchBonusBall.equals(winningStatus.hasBonusBall()))).
                    count();
            mappingMatchedLottoWithWinningMoney.add(lottoWinningResultsCount);
            System.out.println("----------------------");
            System.out.println(winningStatus.getMatchCount());
            System.out.println(lottoWinningResultsCount);
        }
        return mappingMatchedLottoWithWinningMoney;
    }

}
