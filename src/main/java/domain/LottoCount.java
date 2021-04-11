package domain;

import java.util.Objects;

public class LottoCount {
    private static final int MINIMUM_MANUAL_LOTTO_COUNT = 0;
    private final int manualLottoCount;
    private final int lottoCount;

    public LottoCount(int lottoCount) {
        this(lottoCount, MINIMUM_MANUAL_LOTTO_COUNT);
    }

    public LottoCount(int lottoCount, int manualLottoCount) {
        this.lottoCount = lottoCount;
        this.manualLottoCount = manualLottoCount;
    }

    public boolean hasManualLottoCount() {
        return manualLottoCount != 0;
    }

    public Money getBuyMoney(int lottoPrice) {
        return new Money(lottoCount * lottoPrice);
    }

    public int getAutoLottoCount() {
        return lottoCount - manualLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoCount that = (LottoCount) o;
        return manualLottoCount == that.manualLottoCount &&
                lottoCount == that.lottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLottoCount, lottoCount);
    }
}