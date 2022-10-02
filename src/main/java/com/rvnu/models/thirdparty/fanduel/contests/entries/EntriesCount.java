package com.rvnu.models.thirdparty.fanduel.contests.entries;

import com.rvnu.models.thirdparty.iso.PositiveInteger;

public class EntriesCount extends PositiveInteger {
    public EntriesCount(final long value) throws ValueMustBePositive, ValueMustNotBeNegative {
        super(value);
    }
}
