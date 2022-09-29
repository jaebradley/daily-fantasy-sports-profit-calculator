package com.rvnu.models.firstparty;

import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import org.javamoney.moneta.Money;

public class Fees extends NonNegativeMonetaryValue {
    public Fees(final Money value) throws ValueMustNotBeNegative {
        super(value);
    }
}
