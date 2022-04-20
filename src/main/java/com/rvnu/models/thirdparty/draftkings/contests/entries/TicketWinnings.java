package com.rvnu.models.thirdparty.draftkings.contests.entries;

import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import org.javamoney.moneta.Money;

public class TicketWinnings extends NonNegativeMonetaryValue {
    public TicketWinnings(final Money value) throws ValueMustNotBeNegative {
        super(value);
    }
}
