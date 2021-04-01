package lotto.domain;

import lotto.domain.lastweekwinninglotto.LastWeekWinningBonusBall;
import lotto.domain.lastweekwinninglotto.LastWeekWinningLotto;
import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.Lottos;
import lotto.domain.lottoticket.NumberOfLottoTicket;
import lotto.domain.lottowinningresult.LottoWinningBonusBallResult;
import lotto.domain.lottowinningresult.LottoWinningResult;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    EnumWinningStatus enumWinningStatus = new EnumWinningStatus();
    public void Discriminator(
            Lottos lottos,
            LastWeekWinningLotto lastWeekWinningLotto,
            LastWeekWinningBonusBall lastWeekWinningBonusBall,
            NumberOfLottoTicket numberOfLottoTicket
    ){
        ArrayList<Integer> lottoWinningResults = new ArrayList<>();
        ArrayList<Boolean> lottoWinningBonusBallResults = new ArrayList<>();

        for (LottoTicket lotto : lottos.getLottos())
        {
            List<Boolean> lottoMatchedResult = getMatchLottoNumber(lotto, lastWeekWinningLotto);
            Boolean lottoMatchedBonusBallResult = getMatchLottoBonusBallNumber(lotto, lastWeekWinningBonusBall);

            int matchLottoNumberCount = getMatchLottoNumberCount(lottoMatchedResult);
            lottoWinningBonusBallResults.add(lottoMatchedBonusBallResult);
            lottoWinningResults.add(matchLottoNumberCount);
            System.out.println(matchLottoNumberCount);
            System.out.println(lottoMatchedBonusBallResult);

        }
        LottoWinningBonusBallResult lottoWinningBonusBallResult = new LottoWinningBonusBallResult(lottoWinningBonusBallResults);
        LottoWinningResult winningResult = new LottoWinningResult(lottoWinningResults);
        LottoFactory lottoFactory = new LottoFactory(winningResult, lottoWinningBonusBallResult);
        enumWinningStatus.mappingMatchedLottoWithWinningMoney(lottoFactory, numberOfLottoTicket);
    }

    private int getMatchLottoNumberCount(List<Boolean> lottoMatchedResult){
        return (int) lottoMatchedResult.stream().filter(index-> (index)).count();
    }

    private List<Boolean> getMatchLottoNumber(LottoTicket lotto, LastWeekWinningLotto lastWeekWinningLotto){
        List<Integer> lottoList = lotto.getLotto();
        List<Integer> lastWeekWinningLottoList = lastWeekWinningLotto.getLotto();
        ArrayList<Boolean> lottoMatchedResult = new ArrayList<>();
        for (int winningLottoNumber = 0; winningLottoNumber < lastWeekWinningLottoList.size(); winningLottoNumber++) {
            Boolean isMatchLottoNumber = lottoList.contains(lastWeekWinningLottoList.get(winningLottoNumber));
            lottoMatchedResult.add(isMatchLottoNumber);
        }
        return lottoMatchedResult;
    }

    private Boolean getMatchLottoBonusBallNumber(LottoTicket lotto, LastWeekWinningBonusBall lastWeekWinningBonusBall) {
        List<Integer> lottoBonusBallList = lotto.getLotto();
        int lastWeekWinningBonusBallList = lastWeekWinningBonusBall.getLastWeekWinningBonusBall();
        Boolean isMatchLottoNumber = lottoBonusBallList.contains(lastWeekWinningBonusBallList);
        return isMatchLottoNumber;

    }
}
