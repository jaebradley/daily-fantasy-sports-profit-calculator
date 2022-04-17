package com.rvnu.models.thirdparty.draftkings;

import com.rvnu.models.thirdparty.iso.PositiveInteger;

public final class ContestKey extends PositiveInteger {
    public ContestKey(final long value) throws ValueMustBePositive, ValueMustNotBeNegative {
        super(value);
    }
}
