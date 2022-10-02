package com.rvnu.models.thirdparty.fanduel.contests.entries;

import com.rvnu.models.thirdparty.iso.NaturalNumber;

public class EntryId extends NaturalNumber {
    public EntryId(final long value) throws ValueMustNotBeNegative {
        super(value);
    }
}
