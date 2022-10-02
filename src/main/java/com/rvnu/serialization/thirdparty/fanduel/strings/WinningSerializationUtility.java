package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.Winnings;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import com.rvnu.serialization.firstparty.strings.impl.AbstractNonNegativeMonetaryValueSerializationUtility;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.MonetaryAmountDecimalFormat;

import javax.money.format.MonetaryAmountFormat;

public class WinningSerializationUtility extends AbstractNonNegativeMonetaryValueSerializationUtility<Winnings> {
    private static final WinningSerializationUtility INSTANCE = new WinningSerializationUtility(MonetaryAmountDecimalFormat.of());

    private WinningSerializationUtility(final MonetaryAmountFormat format) {
        super(format);
    }

    @Override
    protected final Winnings construct(final Money value) throws NonNegativeMonetaryValue.ValueMustNotBeNegative {
        return new Winnings(value);
    }

    public static WinningSerializationUtility getInstance() {
        return INSTANCE;
    }
}
