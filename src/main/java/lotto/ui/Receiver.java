package lotto.ui;

import java.util.Scanner;

public class Receiver {
    private static final Scanner scanner = new Scanner(System.in);

    public int receiveLottoPurchaseAmount() {
        return scanner.nextInt();
    }

    public int receiverLottoManualTicketNumber() {return scanner.nextInt();}
}
