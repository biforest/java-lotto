package domain.lotteryStore.numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import ui.message.ExceptionMessage;

public class ManualNumbersGenerator {
    private static final String CHARACTERS_CONTAINING_NUMBER_COMMA = "^[0-9,\\s]+$";
    private static final int SIZE_OF_NUMBERS = 6;
    private static final String DELIMITER = ",";
    private static final String CHARACTER_BEFORE_REPLACING = " ";
    private static final String CHARACTER_AFTER_REPLACING = "";

    private final List<LotteryNumber> manualNumbers;

    private ManualNumbersGenerator(String manualNumbers) {
        validateOtherCharacterSymbols(manualNumbers);
        this.manualNumbers = splitWinningNumbers(manualNumbers);
        validateSplitInput();
    }

    public static Lottery createWinningNumbers(String winningNumbers) {
        return Lottery.from(createManualLotteryNumbers(winningNumbers));
    }

    public static List<LotteryNumber> createManualLotteryNumbers(String manualNumbers) {
        return new ManualNumbersGenerator(manualNumbers).manualNumbers;
    }

    private void validateOtherCharacterSymbols(String input) {
        if (!Pattern.matches(CHARACTERS_CONTAINING_NUMBER_COMMA, input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_ONLY_NUMBERS_AND_COMMA.getMessage());
        }
    }

    private List<LotteryNumber> splitWinningNumbers(String input) {
        return Arrays.stream(
            input.replaceAll(CHARACTER_BEFORE_REPLACING, CHARACTER_AFTER_REPLACING)
                .split(DELIMITER))
            .map(Integer::parseInt)
            .map(LotteryNumber::from)
            .collect(Collectors.toList());
    }

    private void validateSplitInput() {
        validateSizeOfWinningNumbers();
        validateDuplicateWinningNumbers();
    }

    private void validateSizeOfWinningNumbers() {
        if (manualNumbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException(ExceptionMessage.MUST_INPUT_SIX_WINNING_NUMBERS.getMessage());
        }
    }

    private void validateDuplicateWinningNumbers() {
        Set<LotteryNumber> numbers = new HashSet<>(manualNumbers);
        if (numbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }
}
