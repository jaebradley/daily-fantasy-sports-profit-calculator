package com.rvnu.models.thirdparty.draftkings;

import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import org.javamoney.moneta.Money;

public class NonTicketWinnings extends NonNegativeMonetaryValue {
    public NonTicketWinnings(final Money value) throws ValueMustNotBeNegative {
        super(value);
    }
}
