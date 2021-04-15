package ui.message;

public enum ExceptionMessage {
    MUST_BUY_MORE_THAN_ONE_TICKET("한 장 이상 구매하셔야 합니다."),
    DUPLICATE_NUMBERS("중복 번호를 입력할 수 없습니다."),
    BONUS_NUMBER_CANNOT_EQUAL_WINNING_NUMBERS("당첨 번호와 일치하는 보너스 번호는 입력할 수 없습니다."),
    MUST_INPUT_NUMBERS_IN_VALID_RANGE("1과 45 사이 번호를 입력해야 합니다."),
    MUST_INPUT_SIX_WINNING_NUMBERS("6개의 당첨 번호를 입력해야 합니다."),
    INPUT_ONLY_NUMBERS_AND_COMMA("숫자와 , 이외의 문자는 입력할 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
