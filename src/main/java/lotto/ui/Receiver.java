package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Receiver {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ", ";

    public int receiveLottoPurchaseAmount() {
        return scanner.nextInt();
    }

    public int receiverLottoManualTicketNumber() {
        return scanner.nextInt();
    }

    public List<Integer> receiverLottoManualTickets() {
        String lottoTicket = scanner.next();
        List<String> lottoManualTicket = splitInputDelimiter(lottoTicket);
        return convertStringToInt(lottoManualTicket);
    }

    private List<Integer> convertStringToInt(List<String> lottoManualTicket) {
        return lottoManualTicket.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> splitInputDelimiter(String lottoManualTicket) {
        return Arrays.asList(lottoManualTicket.split(DELIMITER));
    }
}
