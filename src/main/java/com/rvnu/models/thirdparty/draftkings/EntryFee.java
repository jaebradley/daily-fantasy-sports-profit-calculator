package com.rvnu.models.thirdparty.draftkings;

import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import org.javamoney.moneta.Money;

public final class EntryFee extends NonNegativeMonetaryValue {
    public EntryFee(final Money value) throws ValueMustNotBeNegative {
        super(value);
    }
}
