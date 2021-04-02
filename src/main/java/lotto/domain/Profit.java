package lotto.domain;

import lotto.domain.lottoticket.NumberOfLottoTicket;

import java.util.List;

public class Profit {
    private static int totalLottoPrice;
    public Profit(List<Integer> lottoPrices) {
        int sumLottoPrices = sumLottoPrices(lottoPrices);
        totalLottoPrice = sumLottoPrices;
    }

    private int sumLottoPrices(List<Integer> lottoPrices){
        return lottoPrices.stream().mapToInt(Integer::intValue).sum();
    }

    public float getCalculatedProfit(NumberOfLottoTicket numberOfLottoTicket) {
        return (float) totalLottoPrice / numberOfLottoTicket.getMoney();
    }
}
