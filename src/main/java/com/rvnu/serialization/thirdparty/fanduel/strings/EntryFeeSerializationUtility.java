package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.EntryFee;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import com.rvnu.serialization.firstparty.strings.impl.AbstractNonNegativeMonetaryValueSerializationUtility;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.MonetaryAmountDecimalFormat;

import javax.money.format.MonetaryAmountFormat;

// TODO: @jbradley this can potentially be moved to a "DecimalFormattedEntryFeeSerializationUtility" that can be shared
public class EntryFeeSerializationUtility extends AbstractNonNegativeMonetaryValueSerializationUtility<EntryFee> {
    private static final EntryFeeSerializationUtility INSTANCE = new EntryFeeSerializationUtility(MonetaryAmountDecimalFormat.of());

    private EntryFeeSerializationUtility(final MonetaryAmountFormat format) {
        super(format);
    }

    @Override
    protected final EntryFee construct(final Money value) throws NonNegativeMonetaryValue.ValueMustNotBeNegative {
        return new EntryFee(value);
    }

    public static EntryFeeSerializationUtility getInstance() {
        return INSTANCE;
    }
}
