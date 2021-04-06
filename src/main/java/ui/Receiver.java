package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ui.message.InputMessage;

public class Receiver {
    private static final Scanner SCANNER = new Scanner(System.in);

    public int receivePurchasePrice() {
        System.out.println(InputMessage.INPUT_PURCHASE_PRICE.getMessage());
        return SCANNER.nextInt();
    }

    public int receiveManualCount() {
        System.out.println(InputMessage.INPUT_MANUAL_COUNT.getMessage());
        SCANNER.nextLine();
        return SCANNER.nextInt();
    }

    public List<String> receiveManualNumbers(int manualCount) {
        System.out.println(InputMessage.INPUT_MANUAL_NUMBERS.getMessage());
        SCANNER.nextLine();
        List<String> inputManualNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            inputManualNumbers.add(SCANNER.nextLine());
        }
        return inputManualNumbers;
    }

    public String receiveWinningNumbers() {
        System.out.println(InputMessage.INPUT_LAST_WEEK_WINNING_NUMBERS.getMessage());
        SCANNER.nextLine();
        return SCANNER.nextLine();
    }

    public int receiveBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_BALL.getMessage());
        return SCANNER.nextInt();
    }
}
