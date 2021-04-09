package lotto.ui;

import java.io.InputStream;
import java.util.Scanner;

public class Receiver {
    private final Scanner scanner;

    public Receiver(InputStream in) {
        scanner = new Scanner(in);
    }

    public String receiveLine() {
        return scanner.nextLine();
    }
}
