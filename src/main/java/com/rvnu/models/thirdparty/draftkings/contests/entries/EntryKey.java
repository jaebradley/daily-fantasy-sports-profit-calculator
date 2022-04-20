package com.rvnu.models.thirdparty.draftkings.contests.entries;

import com.rvnu.models.thirdparty.iso.PositiveInteger;

public final class EntryKey extends PositiveInteger {
    public EntryKey(final long value) throws ValueMustBePositive, ValueMustNotBeNegative {
        super(value);
    }
}
