package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.PrizePool;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import com.rvnu.serialization.firstparty.strings.impl.AbstractNonNegativeMonetaryValueSerializationUtility;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.MonetaryAmountDecimalFormat;

import javax.money.format.MonetaryAmountFormat;

public class PrizePoolSerializationUtility extends AbstractNonNegativeMonetaryValueSerializationUtility<PrizePool> {
    private static final PrizePoolSerializationUtility INSTANCE = new PrizePoolSerializationUtility(MonetaryAmountDecimalFormat.of());

    private PrizePoolSerializationUtility(final MonetaryAmountFormat format) {
        super(format);
    }

    @Override
    protected PrizePool construct(final Money value) throws NonNegativeMonetaryValue.ValueMustNotBeNegative {
        return new PrizePool(value);
    }

    public static PrizePoolSerializationUtility getInstance() {
        return INSTANCE;
    }
}
