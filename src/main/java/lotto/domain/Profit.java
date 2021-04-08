package lotto.domain;

import java.util.List;

public class Profit {
    private static final int PROFIT_THRESHOLD = 1;

    private final int sumLottoPrices;
    private final NumberOfLottoTicket numberOfLottoTicket;
    private final float calculatedProfit;

    public Profit(List<WinningStatus> lottoPrices, NumberOfLottoTicket numberOfLottoTicket) {
        this.sumLottoPrices = sumLottoPrices(lottoPrices);
        this.numberOfLottoTicket = numberOfLottoTicket;
        this.calculatedProfit = CalculatedProfit();
    }

    private int sumLottoPrices(List<WinningStatus> lottoPrices){
        return lottoPrices.stream().mapToInt(WinningStatus::getWinningMoney).sum();
    }

    private float CalculatedProfit() {
        return (float) sumLottoPrices / (numberOfLottoTicket.getTotalNumberOfLottoTicket() * numberOfLottoTicket.getLottoTicketPrice());
    }

    public boolean isProfit() {
        if (calculatedProfit<PROFIT_THRESHOLD) {
            return false;
        }
        return true;
    }

    public float getProfit() {
        return calculatedProfit;
    }
}
