package domain;

import domain.lottoticket.NumberOfLottoTicket;
import domain.lottowinningresult.LottoWinningBonusBallResult;
import domain.lottowinningresult.LottoWinningResult;
import ui.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnumWinningStatus {
    private static final int NOT_MATCH_LOTTO = 0;
    private ArrayList<WinningStatus> lottoPrices = new ArrayList<>();
    private Map<WinningStatus, Integer> mappingLottoWithBonusBall = new HashMap<>();
    private Printer printer = new Printer();

    public ArrayList<WinningStatus> getLottoPrices(LottoFactory lottoFactory, NumberOfLottoTicket numberOfLottoTicket){
        LottoWinningResult lottoWinningResults = lottoFactory.getLottoWinningResult();
        LottoWinningBonusBallResult lottoWinningBonusBallResult = lottoFactory.getLottoWinningBonusBallResult();

        for (int i = 0; i < numberOfLottoTicket.getNumberOfLottoTicket(); i++) {
            int lottoMatchedNumber = lottoWinningResults.getLottoWinningResult().get(i);
            Boolean lottoBonusBallNumber = lottoWinningBonusBallResult.getLottoWinningBonusBallResult().get(i);
            getWinningLottoTicketPrices(lottoMatchedNumber, lottoBonusBallNumber);
        }
        printer.printWinningStatistics();
        printer.printAllMatchedLottoResults(getMappingLottoWithBonusBall());
        return lottoPrices;
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
            lottoPrices.add(winningStatus);
        }
    }

    private Map<WinningStatus, Integer> getMappingLottoWithBonusBall() {
        for (WinningStatus key: lottoPrices) {
            mappingLottoWithBonusBall.put(key, mappingLottoWithBonusBall.getOrDefault(key, 0)+1);
        }
        return mappingLottoWithBonusBall;
    }

}