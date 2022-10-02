package com.rvnu.models.thirdparty.fanduel.contests.entries;

import com.rvnu.models.thirdparty.iso.PositiveInteger;

public class ContestPlace extends PositiveInteger {
    public ContestPlace(final long value) throws ValueMustBePositive, ValueMustNotBeNegative {
        super(value);
    }
}
