package com.rvnu.models.thirdparty.draftkings;

import com.rvnu.models.thirdparty.iso.PositiveInteger;

public final class ContestPlace extends PositiveInteger {
    public ContestPlace(long value) throws ValueMustBePositive, ValueMustNotBeNegative {
        super(value);
    }
}
