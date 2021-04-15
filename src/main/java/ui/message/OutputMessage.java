package ui.message;

public enum OutputMessage {
    PURCHASED_COUNT("\n수동으로 %d장, 자동으로 %d장을 구매했습니다.\n"),
    WINNING_STATISTICS("\n당첨 통계\n---------\n"),
    MATCH_COUNT("%d개 일치 (%d원)- %d개\n"),
    MATCH_COUNT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n"),
    TOTAL_EARNINGS_RATE("총 수익률은 %.2f입니다.(1 기준)\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
