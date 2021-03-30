package ui;

public enum Message {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_LAST_WEEK_WINNING_NUMBERS("\n지난 주 당첨 번호를 입력해 주세요."),
    INPUT_BONUS_BALL("보너스 볼을 입력해 주세요."),

    PURCHASED_COUNT("개를 구매했습니다."),
    WINNING_STATISTICS("\n당첨 통계\n"),
    BOUNDARY_LINE("---------\n"),
    MATCH_COUNT("개 일치 ("),
    MATCH_COUNT_BONUS("개 일치, 보너스 볼 일치("),
    WON("원)- "),
    COUNT("개\n"),
    TOTAL_EARNINGS_RATE("총 수익률은 "),
    CLOSING_MENTION("입니다.(1 기준)");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
