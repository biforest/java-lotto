package ui;

import java.util.Scanner;

import domain.Message;

public class Receiver {
    private static final Scanner SCANNER = new Scanner(System.in);

    public int receivePurchasePrice() {
        System.out.println(Message.INPUT_PURCHASE_PRICE.getMessage());
        return SCANNER.nextInt();
    }

    public String receiveWinningNumbers() {
        System.out.println(Message.INPUT_LAST_WEEK_WINNING_NUMBERS.getMessage());
        return SCANNER.nextLine();
    }

    public int receiveBonusNumber() {
        System.out.println(Message.INPUT_BONUS_BALL.getMessage());
        return SCANNER.nextInt();
    }
}
