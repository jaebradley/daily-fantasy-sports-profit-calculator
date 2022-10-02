package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.SalaryCap;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import com.rvnu.serialization.firstparty.strings.impl.AbstractNonNegativeMonetaryValueSerializationUtility;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.MonetaryAmountDecimalFormat;

import javax.money.format.MonetaryAmountFormat;

public class SalaryCapSerializationUtility extends AbstractNonNegativeMonetaryValueSerializationUtility<SalaryCap> {
    private static final SalaryCapSerializationUtility INSTANCE = new SalaryCapSerializationUtility(MonetaryAmountDecimalFormat.of());

    private SalaryCapSerializationUtility(final MonetaryAmountFormat format) {
        super(format);
    }

    @Override
    protected final SalaryCap construct(final Money value) throws NonNegativeMonetaryValue.ValueMustNotBeNegative {
        // TODO: "$60k" gets parsed as $60, so multiply by 10,000
        // TODO: @jbradley make this formatting more robust
        return new SalaryCap(value.multiply(1_000));
    }

    public static SalaryCapSerializationUtility getInstance() {
        return INSTANCE;
    }
}
