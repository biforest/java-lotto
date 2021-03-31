package ui.receiver;

import java.util.HashSet;
import java.util.Set;

import domain.lotteryService.BonusNumber;
import domain.lotteryService.WinningNumbers;
import ui.Message;

public class InputValidator {
    private static final int MINIMUM_PURCHASE_PRICE = 1000;
    private static final int MINIMUM_WINNING_NUMBER = 1;
    private static final int MAXIMUM_WINNING_NUMBER = 45;
    private static final int SIZE_OF_WINNING_NUMBERS = 6;

    public static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < MINIMUM_PURCHASE_PRICE) {
            throw new IllegalArgumentException(Message.ExceptionMessage.MUST_BUY_MORE_THAN_ONE_TICKET.getMessage());
        }
    }

    public static void validateOtherCharacterSymbols() {
        // TODO: ,나 숫자 외의 입력이 있을 경우
    }

    public static void validateSizeOfWinningNumbers(WinningNumbers winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(Message.ExceptionMessage.MUST_INPUT_SIX_WINNING_NUMBERS.getMessage());
        }
    }

    public static void validateRangeOfWinningNumbers(WinningNumbers winningNumbers) {
        if (winningNumbers.getWinningNumbers()
            .stream()
            .anyMatch(
                winningNumber -> winningNumber < MINIMUM_WINNING_NUMBER || winningNumber > MAXIMUM_WINNING_NUMBER)) {
            throw new IllegalArgumentException(Message.ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
        }
    }

    public static void validateRangeOfBonusNumber(BonusNumber bonusNumber) {
        if (bonusNumber.getBonusNumber() < MINIMUM_WINNING_NUMBER
            || bonusNumber.getBonusNumber() > MAXIMUM_WINNING_NUMBER) {
            throw new IllegalArgumentException(Message.ExceptionMessage.MUST_INPUT_NUMBERS_IN_VALID_RANGE.getMessage());
        }
    }

    public static void validateDuplicateWinningNumbers(WinningNumbers winningNumbers) {
        Set<Integer> numbers = new HashSet<>(winningNumbers.getWinningNumbers());
        if (numbers.size() != SIZE_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException(Message.ExceptionMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }

    public static void validateBonusNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(
                Message.ExceptionMessage.BONUS_NUMBER_CANNOT_EQUAL_WINNING_NUMBERS.getMessage());
        }
    }
}
