package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.TicketWinnings;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import com.rvnu.serialization.firstparty.strings.impl.AbstractNonNegativeMonetaryValueSerializationUtility;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.MonetaryAmountDecimalFormat;

import javax.money.format.MonetaryAmountFormat;

public class TicketWinningsSerializationUtility extends AbstractNonNegativeMonetaryValueSerializationUtility<TicketWinnings> {
    private static final TicketWinningsSerializationUtility INSTANCE = new TicketWinningsSerializationUtility(MonetaryAmountDecimalFormat.of());

    private TicketWinningsSerializationUtility(final MonetaryAmountFormat format) {
        super(format);
    }

    @Override
    protected TicketWinnings construct(final Money value) throws NonNegativeMonetaryValue.ValueMustNotBeNegative {
        return new TicketWinnings(value);
    }

    public static TicketWinningsSerializationUtility getInstance() {
        return INSTANCE;
    }
}
