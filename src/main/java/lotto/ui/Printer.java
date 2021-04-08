package lotto.ui;

import lotto.domain.NumberOfLottoTicket;
import lotto.domain.WinningStatus;
import lotto.domain.lotto.LottoAutomaticTicket;
import lotto.domain.lotto.LottoAutomaticTickets;
import lotto.domain.lotto.LottoManualTicket;
import lotto.domain.lotto.LottoManualTickets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Printer {
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_MANUAL_TICKET_NUMBER_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String REQUEST_LOTTO_MANUAL_TICKET_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PRINT_NUMBER_OF_LOTTO_TICKET_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_LOTTO_BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해주세요";
    private static final String PRINT_FINAL_MATCHED_LOTTO_RESULT_MESSAGE = "%s개 일치%s(%s원)- ";
    private static final String PRINT_MATCH_BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String PRINT_PROFIT_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String PRINT_LOTTO_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void requestLottoManualTicketNumber() {
        System.out.println(REQUEST_LOTTO_MANUAL_TICKET_NUMBER_MESSAGE);
    }

    public void requestLottoManualTicket() {
        System.out.println(REQUEST_LOTTO_MANUAL_TICKET_MESSAGE);
    }

    public void printNumberOfEachLottoTicket(NumberOfLottoTicket numberOfLottoTicket) {
        System.out.println(String.format(
                PRINT_NUMBER_OF_LOTTO_TICKET_MESSAGE,
                numberOfLottoTicket.getNumberOfManualLottoTicket(),
                numberOfLottoTicket.getAutomaticLottoTicketOfNumber()
        ));
    }

    public void printLottoAutomaticTickets(LottoAutomaticTickets lottoAutomaticTickets) {
        for (LottoAutomaticTicket lottoAutomaticTicket: lottoAutomaticTickets.getLottoAutomaticTickets()) {
            System.out.println(lottoAutomaticTicket.getLotto());
        }
    }

    public void printLottoManualTickets(LottoManualTickets lottoManualTickets) {
        for (LottoManualTicket lottoManualTicket: lottoManualTickets.getLottoManualTickets()) {
            System.out.println(lottoManualTicket.getLotto());
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


    public void requestLastWeekLottoWinningNumber() {
        System.out.println(REQUEST_LAST_WEEK_LOTTO_WINNING_NUMBER_MESSAGE);
    }

    public void requestLottoBonusBallNumber() {
        System.out.println(REQUEST_LOTTO_BONUS_BALL_NUMBER_MESSAGE);
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
}
