package domain.value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.value.validator.WinningNumbersValidator;

public class WinningNumbers {
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY_STRING = "";

    private final List<Integer> winningNumbers;
    private final WinningNumbersValidator validator;

    public WinningNumbers(String winningNumbers) {
        validator = new WinningNumbersValidator();
        this.winningNumbers = splitWinningNumbers(winningNumbers);
    }

    private List<Integer> splitWinningNumbers(String input) {
        validator.validateOtherCharacterSymbols(input);

        List<Integer> splitInput = Arrays.stream(input.replaceAll(BLANK, EMPTY_STRING)
            .split(COMMA))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        validateSplitInput(splitInput);
        return splitInput;
    }

    private void validateSplitInput(List<Integer> splitInput) {
        validator.validateSizeOfWinningNumbers(splitInput);
        validator.validateRangeOfWinningNumbers(splitInput);
        validator.validateDuplicateWinningNumbers(splitInput);
    }

    public boolean contains(int numberToCompare) {
        return winningNumbers.contains(numberToCompare);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
