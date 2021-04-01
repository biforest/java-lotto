package UI;

import java.util.Scanner;

public class Receiver {
    Scanner scanner = new Scanner(System.in);

    public String receiveLine(){
        return scanner.nextLine();
    }
}
