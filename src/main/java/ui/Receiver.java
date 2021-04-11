package ui;

import domain.LottoCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Receiver {

    private static final String REQUEST_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String RECEIVE_MANUAL_NUMBER_OF_LOTTO_TICKETS_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String RECEIVE_MANUAL_LOTTO_NUMBERS = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String RECEIVE_WINNING_LOTTO_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String RECEIVE_BONUS_BALL_MESSAGE = "보너스 볼을 입력해주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public Receiver() {
    }

    public int receiveMoney() {
        System.out.println(REQUEST_MONEY_MESSAGE);
        return SCANNER.nextInt();
    }

    public int receiveManualNumberOfLottoTickets() {
        System.out.println(RECEIVE_MANUAL_NUMBER_OF_LOTTO_TICKETS_MESSAGE);
        int manualLottoCount = SCANNER.nextInt();
        SCANNER.nextLine();
        return manualLottoCount;
    }

    public List<String> receiveManualLottoNumbers(LottoCount lottoCount) {
        System.out.println(RECEIVE_MANUAL_LOTTO_NUMBERS);
        List<String> manualLottoNumbers = new ArrayList<>();
        int manualLottoCount = lottoCount.getManualLottoCount();
        for (int i =0; i < manualLottoCount; i++){
            manualLottoNumbers.add(SCANNER.nextLine());
        }
        return manualLottoNumbers;
    }

    public String receiveWinningLottoNumbers() {
        System.out.println(RECEIVE_WINNING_LOTTO_NUMBERS_MESSAGE);
        return SCANNER.nextLine();
    }
    
    public int receiveBonusBall() {
        System.out.println(RECEIVE_BONUS_BALL_MESSAGE);
        return SCANNER.nextInt();
    }
}
