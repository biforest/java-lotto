package lotto.domain;

import lotto.domain.lottoticket.NumberOfLottoTicket;
import lotto.domain.lottowinningresult.LottoWinningBonusBallResult;
import lotto.domain.lottowinningresult.LottoWinningResult;

import java.util.ArrayList;
import java.util.List;

public class EnumWinningStatus {
    private ArrayList<Integer> lottoPrices = new ArrayList<>();
    public List<Long> mappingMatchedLottoWithWinningMoney(LottoFactory lottoFactory, NumberOfLottoTicket numberOfLottoTicket){
        ArrayList<Long> mappingMatchedLottoWithWinningMoney = new ArrayList<>();
        LottoWinningResult lottoWinningResults = lottoFactory.getLottoWinningResult();
        LottoWinningBonusBallResult lottoWinningBonusBallResult = lottoFactory.getLottoWinningBonusBallResult();

        for (int i = 0; i < numberOfLottoTicket.getNumberOfLottoTicket(); i++) {
            int lottoMatchedNumber = lottoWinningResults.getLottoWinningResult().get(i);
            Boolean lottoBonusBallNumber = lottoWinningBonusBallResult.getLottoWinningBonusBallResult().get(i);
            getWinningLottoTicketPrices(lottoMatchedNumber, lottoBonusBallNumber);
        }
        System.out.println(lottoPrices);
        return mappingMatchedLottoWithWinningMoney;
    }

    private void getWinningLottoTicketPrices(int lottoMatchedNumber, boolean lottoBonusBallNumber) {
        for(WinningStatus winningStatus: WinningStatus.values()){
            int matchedWinningNumberCount = winningStatus.getMatchCount();
            boolean isMatchedBonusBallCount = winningStatus.hasBonusBall();
            makeWinningLottoTicket(lottoMatchedNumber, matchedWinningNumberCount, isMatchedBonusBallCount, lottoBonusBallNumber, winningStatus);
        }
    }

    private void makeWinningLottoTicket(
            int lottoMatchedNumber,
            int matchedWinningNumberCount,
            boolean isMatchedBonusBallCount,
            boolean lottoBonusBallNumber,
            WinningStatus winningStatus
    ){
        if((lottoMatchedNumber == matchedWinningNumberCount) && (isMatchedBonusBallCount == lottoBonusBallNumber)){
            lottoPrices.add(winningStatus.getWinningMoney());
        }

    }

}
