package lotto.ui;

import lotto.domain.WinningStatus;
import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.Lottos;
import lotto.domain.lottoticket.NumberOfLottoTicket;

import java.util.*;

public class Printer {
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_LOTTO_BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해주세요";
    private static final String PRINT_FINAL_MATCHED_LOTTO_RESULT_MESSAGE = "%s개 일치%s(%s원)- ";
    private static final String PRINT_LOTTO_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String PRINT_MATCH_BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String PRINT_DIVIDER_MESSAGE = "---------\n";
    private static final String PRINT_WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n";
    private static final String PRINT_PROFIT_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String PRINT_NUMBER_OF_LOTTO_TICKET = "개를 구매했습니다.";

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void requestLastWeekLottoWinningNumber() {
        System.out.println(REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE);
    }

    public void requestLottoBonusBallNumber() {
        System.out.println(REQUEST_LOTTO_BONUS_BALL_NUMBER_MESSAGE);
    }

    public void printWinningStatistics() {
        System.out.print(PRINT_WINNING_STATISTICS_MESSAGE);
        System.out.print(PRINT_DIVIDER_MESSAGE);
    }

    public void printAllLotto(Lottos lottos) {
        for (LottoTicket lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }

    public void printAllMatchedLottoResults(Map<WinningStatus, Integer> lottoPrices) {
        List<WinningStatus> keySet = new ArrayList(lottoPrices.keySet());
        keySet.sort(Comparator.comparingInt(WinningStatus::getWinningMoney));

        for(WinningStatus winningStatus: WinningStatus.values()){
            printMatchedLottoWithBonusBallFormat(winningStatus);
            printMatchedLottoFormat(winningStatus);
            printMatchedLottoResult(winningStatus, lottoPrices);
        }
    }

    private void printMatchedLottoResult(WinningStatus winningStatus, Map<WinningStatus, Integer> lottoPrices) {
        if (lottoPrices.get(winningStatus) == null){
            System.out.println("0개");
        }
        if (lottoPrices.get(winningStatus) != null){
            System.out.println(lottoPrices.get(winningStatus)+"개");
        }
    }

    private void printMatchedLottoFormat(WinningStatus winningStatus) {
        if (!winningStatus.hasBonusBall()) {
            System.out.print(String.format(
                    PRINT_FINAL_MATCHED_LOTTO_RESULT_MESSAGE,
                    winningStatus.getMatchCount(),
                    "",
                    winningStatus.getWinningMoney()));
        }
    }

    private void printMatchedLottoWithBonusBallFormat(WinningStatus winningStatus) {
        if (winningStatus.hasBonusBall()){
            System.out.print(String.format(
                    PRINT_FINAL_MATCHED_LOTTO_RESULT_MESSAGE,
                    winningStatus.getMatchCount(),
                    PRINT_MATCH_BONUS_BALL_MESSAGE,
                    winningStatus.getWinningMoney()));
        }
    }

    public void printLottoProfit(float calculatedProfit) {
        System.out.print(String.format(PRINT_LOTTO_PROFIT_MESSAGE, calculatedProfit));
    }

    public void printIsLottoProfit(boolean isProfit) {
        if(!isProfit) {
            System.out.println(PRINT_PROFIT_LOSS_MESSAGE);
        }
    }

    public void printNumberOfLottoTicket(NumberOfLottoTicket numberOfLottoTicket) {
        System.out.println(numberOfLottoTicket.getNumberOfLottoTicket() + PRINT_NUMBER_OF_LOTTO_TICKET);
    }
}

