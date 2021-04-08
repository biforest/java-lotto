package lotto.domain;

import lotto.ui.Printer;
import lotto.ui.Receiver;

public class LottoStore {
    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();

    public PurchaseAmount inputLottoPurchaseAmount() {
        printer.requestPurchaseAmount();
        int lottoPurchaseAmount = receiver.receiveLottoPurchaseAmount();

        return new PurchaseAmount(lottoPurchaseAmount);
    }
}
