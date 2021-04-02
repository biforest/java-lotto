package lotto.ui;
import java.util.Scanner;
public class Receiver {
    private final Scanner scanner;
    public Receiver() {
        scanner = new Scanner(System.in);
    }
    public String receiveLine() {
        return scanner.nextLine();
    }
}