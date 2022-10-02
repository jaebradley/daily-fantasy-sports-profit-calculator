package com.rvnu.models.thirdparty.fanduel.contests.entries;

import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import org.javamoney.moneta.Money;

public class SalaryCap extends NonNegativeMonetaryValue {
    public SalaryCap(final Money value) throws ValueMustNotBeNegative {
        super(value);
    }
}
