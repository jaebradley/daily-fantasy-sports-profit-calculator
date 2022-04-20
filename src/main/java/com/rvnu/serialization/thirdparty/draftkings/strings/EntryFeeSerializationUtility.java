package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.contests.entries.EntryFee;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import com.rvnu.serialization.firstparty.strings.impl.AbstractNonNegativeMonetaryValueSerializationUtility;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.MonetaryAmountDecimalFormat;

import javax.money.format.MonetaryAmountFormat;

public class EntryFeeSerializationUtility extends AbstractNonNegativeMonetaryValueSerializationUtility<EntryFee> {
    private static final EntryFeeSerializationUtility INSTANCE = new EntryFeeSerializationUtility(
            MonetaryAmountDecimalFormat.of()
    );

    private EntryFeeSerializationUtility(final MonetaryAmountFormat format) {
        super(format);
    }

    @Override
    protected EntryFee construct(final Money value) throws NonNegativeMonetaryValue.ValueMustNotBeNegative {
        return new EntryFee(value);
    }

    public static EntryFeeSerializationUtility getInstance() {
        return INSTANCE;
    }
}
