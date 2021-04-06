package ui.message;

public enum OutputMessage {
    PURCHASED_COUNT("\n수동으로 %d장, 자동으로 %d개를 구매했습니다."),
    WINNING_STATISTICS("\n당첨 통계\n"),
    BOUNDARY_LINE("---------\n"),
    MATCH_COUNT("개 일치 ("),
    MATCH_COUNT_BONUS("개 일치, 보너스 볼 일치("),
    WON("원)- "),
    COUNT("개\n"),
    TOTAL_EARNINGS_RATE("총 수익률은 "),
    CLOSING_MENTION("입니다.(1 기준)");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
