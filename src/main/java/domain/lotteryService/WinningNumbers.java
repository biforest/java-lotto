package domain.lotteryService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY_STRING = "";

    final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        this.winningNumbers = splitWinningNumbers(winningNumbers);
        // TODO: bonusNumber와 겹치는 winningNumbers가 있는지 확인 -> 여기서 해야하나?
    }

    private List<Integer> splitWinningNumbers(String input) {
        // TODO: validate 숫자와 쉼표 이외의 문자 포함

        List<Integer> splittedInput = Arrays.stream(input.replaceAll(BLANK, EMPTY_STRING)
            .split(COMMA))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        // TODO: validate winningNumbers가 6개인지
        // TODO: validate 중복된 번호가 있는 경우
        // TODO: validate 1-45 사이의 숫자가 아닐 경우

        return splittedInput;
    }

    public int get(int index) {
        return winningNumbers.get(index);
    }

    public int size() {
        return winningNumbers.size();
    }

    public boolean contains(int numberToCompare) {
        return winningNumbers.contains(numberToCompare);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

}
