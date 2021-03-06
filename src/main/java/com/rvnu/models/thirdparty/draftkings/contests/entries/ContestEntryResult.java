package com.rvnu.models.thirdparty.draftkings.contests.entries;

public record ContestEntryResult(
        Sport sport,
        EntryKey entryKey,
        ContestKey contestKey,
        ContestStartTime contestStartTime,
        ContestPlace place,
        EntryPoints points,
        Winnings winnings,
        ContestEntries contestEntries,
        EntryFee entryFee,
        PrizePool prizePool,
        PlacesPaid placesPaid
) {
}
