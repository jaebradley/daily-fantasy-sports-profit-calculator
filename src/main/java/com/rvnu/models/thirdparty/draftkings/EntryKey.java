package com.rvnu.models.thirdparty.draftkings;

import com.rvnu.models.thirdparty.iso.PositiveInteger;

public final class EntryKey extends PositiveInteger {
    public EntryKey(long value) throws ValueMustBePositive, ValueMustNotBeNegative {
        super(value);
    }
}
