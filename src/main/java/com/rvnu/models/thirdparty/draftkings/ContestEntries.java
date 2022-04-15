package com.rvnu.models.thirdparty.draftkings;

import com.rvnu.models.thirdparty.iso.NaturalNumber;

public class ContestEntries extends NaturalNumber {
    public ContestEntries(long value) throws ValueMustNotBeNegative {
        super(value);
    }
}
