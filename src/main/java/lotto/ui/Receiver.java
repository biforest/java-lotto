package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Receiver {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public int receiveLottoTotalAmount() {
        int lottoTotalAmount = scanner.nextInt();
        return lottoTotalAmount;
    }

    public List<Integer> receiveLastWeekLottoWinningNumbers() {
        String lastWeekLottoWinningNumbers = scanner.next();
        List<String> dividedLastWeekLottoWinningNumbers = splitInputLine(lastWeekLottoWinningNumbers);
        return convertStringToInt(dividedLastWeekLottoWinningNumbers);
    }

    private List<String> splitInputLine(String line) {
        return Arrays.asList(line.split(DELIMITER));
    }

    private List<Integer> convertStringToInt(List<String> dividedLastWeekLottoWinningNumbers) {
        return dividedLastWeekLottoWinningNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());

    }
}
