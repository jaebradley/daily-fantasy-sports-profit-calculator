package com.rvnu.models.firstparty;

import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import org.javamoney.moneta.Money;

public class Winnings extends NonNegativeMonetaryValue {
    public Winnings(final Money value) throws ValueMustNotBeNegative {
        super(value);
    }
}
