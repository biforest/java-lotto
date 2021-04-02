package ui;

import domain.WinningStatus;
import domain.lottoticket.LottoTicket;
import domain.lottoticket.Lottos;

import java.util.*;

public class Printer {
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_LOTTO_BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해주세요";
    private static final String PRINT_FINAL_MATCHED_LOTTO_RESULT_MESSAGE = "%s개 일치 (%s원)- %s개";
    private static final String PRINT_LOTTO_PROFIT_MESSAGE = "총 수익률은 %f입니다.";
    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }
    public void requestLastWeekLottoWinningNumber() {
        System.out.println(REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE);
    }
    public void requestLottoBonusBallNumber() {
        System.out.println(REQUEST_LOTTO_BONUS_BALL_NUMBER_MESSAGE);
    }
    public void printAllLotto(Lottos lottos){
        for (LottoTicket lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }

    public void printAllMatchedLottoResult(Map<WinningStatus, Integer> lottoPrices) {
        List<WinningStatus> keySet = new ArrayList(lottoPrices.keySet());
        keySet.sort(Comparator.comparingInt(WinningStatus::getWinningMoney));

        for(WinningStatus key: keySet) {
            System.out.println(String.format(PRINT_FINAL_MATCHED_LOTTO_RESULT_MESSAGE, key.getMatchCount(), key.getWinningMoney(), lottoPrices.get(key)));
        }
    }

    public void printLottoProfit(float calculatedProfit) {
        System.out.println(String.format(PRINT_LOTTO_PROFIT_MESSAGE, calculatedProfit));
    }
}