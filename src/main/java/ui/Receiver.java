package ui;

import java.util.Scanner;

public class Receiver {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String 구입금액_입력 = "구입금액을 입력해 주세요.";
    private static final String 구매했습니다 = "개를 구매했습니다.";
    private static final String 지난주당첨번호 = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String 보너스볼 = "보너스 볼을 입력해 주세요.";

    public int receiveAmount() {
        System.out.println(구입금액_입력);
        int amount = SCANNER.nextInt();
        int count = amount / 1000;
        System.out.println(count + 구매했습니다);
        return count;
    }

    public String receiveWinningNumbers() {
        System.out.println(지난주당첨번호);
        return SCANNER.nextLine();
    }

    public int receiveBonusNumber() {
        System.out.println(보너스볼);
        return SCANNER.nextInt();
    }
}
