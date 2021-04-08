package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {
    @Test
    void Profit_객체를_생성하고_수익률이_1보다_클때_true_를_반환한다() {
        //given
        int purchaseManualLottoOfNumber = 3;
        PurchaseAmount purchaseAmount = new PurchaseAmount(4000);
        NumberOfLottoTicket numberOfLottoTicket = new NumberOfLottoTicket(purchaseAmount, purchaseManualLottoOfNumber);
        List<WinningStatus> lottoPrices = new ArrayList<>();
        for (WinningStatus winningStatus: WinningStatus.values()) {
            if (winningStatus.getWinningMoney() == 5000) {
                lottoPrices.add(winningStatus);
            }
        }
        Profit profit = new Profit(lottoPrices, numberOfLottoTicket);

        //when
        Boolean isProfit = profit.isProfit();

        //then
        assertThat(true).isEqualTo(isProfit);
    }

    @Test
    void Profit_객체를_생성하고_수익률이_1보다_작을_때_false_를_반환한다() {
        //given
        int purchaseManualLottoOfNumber = 3;
        PurchaseAmount purchaseAmount = new PurchaseAmount(6000);
        NumberOfLottoTicket numberOfLottoTicket = new NumberOfLottoTicket(purchaseAmount, purchaseManualLottoOfNumber);
        List<WinningStatus> lottoPrices = new ArrayList<>();
        for (WinningStatus winningStatus: WinningStatus.values()) {
            if (winningStatus.getWinningMoney() == 5000) {
                lottoPrices.add(winningStatus);
            }
        }
        Profit profit = new Profit(lottoPrices, numberOfLottoTicket);

        //when
        Boolean isProfit = profit.isProfit();

        //then
        assertThat(false).isEqualTo(isProfit);
    }
}