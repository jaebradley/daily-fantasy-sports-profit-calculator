package com.rvnu.models.thirdparty.draftkings;

import com.rvnu.models.thirdparty.iso.NaturalNumber;

public final class PlacesPaid extends NaturalNumber {
    public PlacesPaid(final long value) throws ValueMustNotBeNegative {
        super(value);
    }
}
