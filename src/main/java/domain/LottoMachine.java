package domain;

import domain.lastweekwinninglotto.LastWeekWinningBonusBall;
import domain.lastweekwinninglotto.LastWeekWinningLotto;
import domain.lottoticket.LottoTicket;
import domain.lottoticket.Lottos;
import domain.lottoticket.NumberOfLottoTicket;
import domain.lottowinningresult.LottoWinningBonusBallResult;
import domain.lottowinningresult.LottoWinningResult;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    EnumWinningStatus enumWinningStatus = new EnumWinningStatus();
    ArrayList<Integer> lottoWinningResults = new ArrayList<>();
    ArrayList<Boolean> lottoWinningBonusBallResults = new ArrayList<>();

    public ArrayList<WinningStatus> Discriminator(
            Lottos lottos,
            LastWeekWinningLotto lastWeekWinningLotto,
            LastWeekWinningBonusBall lastWeekWinningBonusBall,
            NumberOfLottoTicket numberOfLottoTicket
    ){
        for (LottoTicket lotto : lottos.getLottos())
        {
            List<Boolean> lottoMatchedResult = getMatchLottoNumber(lotto, lastWeekWinningLotto);
            Boolean lottoMatchedBonusBallResult = getMatchLottoBonusBallNumber(lotto, lastWeekWinningBonusBall);
            int matchLottoNumberCount = getMatchLottoNumberCount(lottoMatchedResult);
            lottoWinningResults.add(matchLottoNumberCount);
            lottoWinningBonusBallResults.add(lottoMatchedBonusBallResult);
        }
        LottoFactory lottoFactory = createLottoFactory(lottoWinningResults, lottoWinningBonusBallResults);
        return enumWinningStatus.getLottoPrices(lottoFactory, numberOfLottoTicket);
    }

    private LottoFactory createLottoFactory(ArrayList<Integer> lottoWinningResults, ArrayList<Boolean> lottoWinningBonusBallResults) {
        LottoWinningBonusBallResult lottoWinningBonusBallResult = new LottoWinningBonusBallResult(lottoWinningBonusBallResults);
        LottoWinningResult winningResult = new LottoWinningResult(lottoWinningResults);

        LottoFactory lottoFactory = new LottoFactory(winningResult, lottoWinningBonusBallResult);
        return lottoFactory;
    }

    private int getMatchLottoNumberCount(List<Boolean> lottoMatchedResult){
        return (int) lottoMatchedResult.stream().filter(index-> (index)).count();
    }

    private List<Boolean> getMatchLottoNumber(LottoTicket lotto, LastWeekWinningLotto lastWeekWinningLotto){
        List<Integer> lottoList = lotto.getLotto();
        List<Integer> lastWeekWinningLottos = lastWeekWinningLotto.getLotto();
        ArrayList<Boolean> lottoMatchedResult = new ArrayList<>();

        for (int winningLottoNumber = 0; winningLottoNumber < lastWeekWinningLottos.size(); winningLottoNumber++) {
            Boolean isMatchLottoNumber = lottoList.contains(lastWeekWinningLottos.get(winningLottoNumber));
            lottoMatchedResult.add(isMatchLottoNumber);
        }
        return lottoMatchedResult;
    }

    private Boolean getMatchLottoBonusBallNumber(LottoTicket lotto, LastWeekWinningBonusBall lastWeekWinningBonusBall) {
        List<Integer> lottoBonusBalls = lotto.getLotto();
        int lastWeekWinningBonusBalls = lastWeekWinningBonusBall.getLastWeekWinningBonusBall();
        Boolean isMatchLottoNumber = lottoBonusBalls.contains(lastWeekWinningBonusBalls);
        return isMatchLottoNumber;

    }
}