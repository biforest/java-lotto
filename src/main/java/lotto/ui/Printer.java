package lotto.ui;

import lotto.domain.*;
import lotto.domain.dto.WinningResult;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.result.GameResult;

import java.util.List;

public class Printer {

    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDER_LINE = "----------";
    private static final String WINNING_RESULT_MESSAGE = "%s (%d원) - %d개\n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String PROFIT_MESSAGE = "이익";
    private static final String LOSS_MESSAGE = "손해";

    public void requestPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
    }

    public void printIssuedTickets(LottoTickets lottoTickets) {
        List<LottoTicket> tickets = lottoTickets.getLottoTickets();
        printNumberOfTickets(tickets);
        printLottoTickets(tickets);
    }

    private void printNumberOfTickets(List<LottoTicket> tickets) {
        int numberOfTickets = tickets.size();
        System.out.println(numberOfTickets + PURCHASE_MESSAGE);
    }

    private void printLottoTickets(List<LottoTicket> tickets) {
        tickets.stream()
                .map(LottoTicket::getLottoNumbers)
                .map(LottoNumbers::getLottoNumbers)
                .forEach(System.out::println);
    }

    public void requestWinningNumber() {
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }

    public void printStatistics(Statistics statistics) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDER_LINE);
        for (WinningResult winningResult : statistics.winningResults()) {
            GameResult gameResult = winningResult.getGameResult();
            System.out.printf(WINNING_RESULT_MESSAGE, gameResult.getDescription(), gameResult.getPrize(), winningResult.getNumberOfWinners());
        }
        System.out.println();

        double earningRate = statistics.calculateEarningRate();
        System.out.printf(EARNING_RATE_MESSAGE, earningRate, profitAndLossMessage(statistics.isProfit(earningRate)));
    }

    private String profitAndLossMessage(boolean isProfit) {
        if (isProfit) {
            return PROFIT_MESSAGE;
        }
        return LOSS_MESSAGE;
    }
}
