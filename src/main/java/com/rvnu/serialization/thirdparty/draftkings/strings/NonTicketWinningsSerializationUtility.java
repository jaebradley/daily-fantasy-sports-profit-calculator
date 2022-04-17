package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.NonTicketWinnings;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import com.rvnu.serialization.firstparty.strings.impl.AbstractNonNegativeMonetaryValueSerializationUtility;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.MonetaryAmountDecimalFormat;

import javax.money.format.MonetaryAmountFormat;

public class NonTicketWinningsSerializationUtility extends AbstractNonNegativeMonetaryValueSerializationUtility<NonTicketWinnings> {
    private static final NonTicketWinningsSerializationUtility INSTANCE = new NonTicketWinningsSerializationUtility(MonetaryAmountDecimalFormat.of());

    private NonTicketWinningsSerializationUtility(final MonetaryAmountFormat format) {
        super(format);
    }

    @Override
    protected NonTicketWinnings construct(final Money value) throws NonNegativeMonetaryValue.ValueMustNotBeNegative {
        return new NonTicketWinnings(value);
    }

    public static NonTicketWinningsSerializationUtility getInstance() {
        return INSTANCE;
    }
}
