package ui.message;

public enum InputMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_MANUAL_COUNT("\n수동으로 구매할 로또 수를 입력해 주세요."),
    INPUT_MANUAL_NUMBERS("\n수동으로 구매할 번호를 입력해 주세요."),
    INPUT_LAST_WEEK_WINNING_NUMBERS("\n지난 주 당첨 번호를 입력해 주세요."),
    INPUT_BONUS_BALL("보너스 볼을 입력해 주세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
