package com.rvnu.models.thirdparty.draftkings.contests.entries;

import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import org.javamoney.moneta.Money;

public final class PrizePool extends NonNegativeMonetaryValue {
    public PrizePool(final Money value) throws ValueMustNotBeNegative {
        super(value);
    }
}
