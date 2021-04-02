package lotto.domain;

import lotto.domain.lottoticket.NumberOfLottoTicket;

import java.util.List;

public class Profit {
    private static int totalLottoPrice;
    public Profit(List<WinningStatus> lottoPrices) {
        int sumLottoPrices = sumLottoPrices(lottoPrices);
        totalLottoPrice = sumLottoPrices;
    }

    private int sumLottoPrices(List<WinningStatus> lottoPrices){
        return lottoPrices.stream().mapToInt(WinningStatus::getWinningMoney).sum();
    }

    public float getCalculatedProfit(NumberOfLottoTicket numberOfLottoTicket) {
        return (float) totalLottoPrice / numberOfLottoTicket.getMoney();
    }
}
