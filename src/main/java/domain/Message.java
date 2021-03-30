package domain;

public enum Message {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_LAST_WEEK_WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_BONUS_BALL("보너스 볼을 입력해 주세요."),
    PURCHASED_COUNT("개를 구매했습니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
