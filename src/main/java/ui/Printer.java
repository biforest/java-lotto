package ui;

import domain.*;

import java.util.Map;

public class Printer {

    private static final String PRINT_NUMBER_OF_LOTTO_TICKETS_MESSAGE = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String PRINT_LOTTO_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String PRINT_WINNING_STATISTICS_MESSAGE = "\n당첨 통계";
    private static final String PRINTER_DIVIDER = "---------";
    private static final String PRINT_LOTTO_MATCHED_LOTTO_RESULT_MESSAGE = "%d개 일치";
    private static final String PRINT_BONUS_BALL_MATCHED_MESSAGE = ", 보너스 볼 일치";
    private static final String PRINT_PRICE_WITH_MATCHED_NUMBER_OF_LOTTOS = " (%d원) - %d개\n";
    private static final String PRINT_PROFIT_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public Printer(){
    }

    public void printNumberOfLottoTickets(LottoCount count) {
        System.out.print(String.format(PRINT_NUMBER_OF_LOTTO_TICKETS_MESSAGE, count.getManualLottoCount(), count.getAutoLottoCount()));
    }

    public void printLottos(Lottos lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public void printLottoProfit(ProfitResult profitResult) {
        System.out.println(PRINT_WINNING_STATISTICS_MESSAGE);
        System.out.println(PRINTER_DIVIDER);
        Map<LottoRank, Integer> lottoResult = profitResult.getLottoResult();
        for (LottoRank lottoRank : lottoResult.keySet()) {
            printLottoMatchedResult(lottoRank, lottoResult.get(lottoRank));
        }
        System.out.print(String.format(PRINT_LOTTO_PROFIT_MESSAGE, profitResult.getProfitRate()));
    }

    public void printLottoMatchedResult(LottoRank lottoRank, Integer count) {
        System.out.print(String.format(PRINT_LOTTO_MATCHED_LOTTO_RESULT_MESSAGE, lottoRank.getMatchCount()));
        if (lottoRank == LottoRank.FIVE_MATCH_WITH_BONUS_BALL) {
            System.out.print(PRINT_BONUS_BALL_MATCHED_MESSAGE);
        }
        System.out.print(String.format(PRINT_PRICE_WITH_MATCHED_NUMBER_OF_LOTTOS, lottoRank.getMoney(), count));
    }

    public void printIsLottoProfit(boolean isProfit) {
        if(!isProfit) {
            System.out.println(PRINT_PROFIT_LOSS_MESSAGE);
        }
    }
}
