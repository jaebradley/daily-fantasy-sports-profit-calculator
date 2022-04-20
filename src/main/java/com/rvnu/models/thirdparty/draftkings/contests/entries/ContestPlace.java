package com.rvnu.models.thirdparty.draftkings.contests.entries;

import com.rvnu.models.thirdparty.iso.PositiveInteger;

public final class ContestPlace extends PositiveInteger {
    public ContestPlace(long value) throws ValueMustBePositive, ValueMustNotBeNegative {
        super(value);
    }
}
