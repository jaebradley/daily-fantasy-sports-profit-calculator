package com.rvnu.data.firstparty.csv.record.impl;

import com.rvnu.data.firstparty.csv.record.interfaces.Record;
import com.rvnu.models.thirdparty.draftkings.ContestEntryResult;
import io.vavr.control.Either;

public class Deserializer implements com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<
        ContestEntryResult,
        Deserializer.Column,
        Deserializer.Error
        > {

    public enum Column {
        SPORT,
        GAME_TYPE,
        ENTRY_KEY,
        ENTRY,
        CONTEST_KEY,
        CONTEST_START_TIME,
        CONTEST_PLACE,
        CONTEST_POINTS,
        WINNINGS,
        CONTEST_ENTRIES,
        ENTRY_FEE,
        PRIZE_POOL,
        PLACES_PAID;,
    }


    public enum Error {
        INVALID_SPORT,
        INVALID_GAME_TYPE,
        INVALID_ENTRY_KEY,
        INVALID_ENTRY,
        INVALID_CONTEST_KEY,
        INVALID_CONTEST_START_TIME,
        INVALID_CONTEST_PLACE,
        INVALID_CONTEST_POINTS,
        INVALID_WINNINGS,
        INVALID_CONTEST_ENTRIES,
        INVALID_ENTRY_FEE,
        INVALID_PRIZE_POOL,
        INVALID_PLACES_PAID;,
    }

    @Override
    public Either<Error, ContestEntryResult> deserialize(final Record<Column> record) {
        throw new RuntimeException();
    }
}
