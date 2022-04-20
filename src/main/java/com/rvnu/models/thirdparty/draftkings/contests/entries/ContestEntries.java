package com.rvnu.models.thirdparty.draftkings.contests.entries;

import com.rvnu.models.thirdparty.iso.NaturalNumber;

public final class ContestEntries extends NaturalNumber {
    public ContestEntries(final long value) throws ValueMustNotBeNegative {
        super(value);
    }
}
