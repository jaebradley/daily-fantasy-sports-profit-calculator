package com.rvnu.models.thirdparty.fanduel.contests.entries;

import com.rvnu.models.thirdparty.iso.PositiveInteger;

import java.math.BigDecimal;

public record Entry(
        EntryId id,
        Sport sport,
        StartDate startDate,
        Name name,
        SalaryCap salaryCap,
        BigDecimal score,
        PositiveInteger contestPlace,
        PositiveInteger entriesCount,
        // TODO: @jbradley how to calculate currency-aware entry fee and winnings?
        // Currency is defined in header name
        BigDecimal entryFee,
        BigDecimal winnings,
        EntryPathIdentifier entryPathIdentifier
) {
}
