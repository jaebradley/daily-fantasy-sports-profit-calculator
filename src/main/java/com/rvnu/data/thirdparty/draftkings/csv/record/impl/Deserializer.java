package com.rvnu.data.thirdparty.draftkings.csv.record.impl;

import com.rvnu.data.firstparty.csv.record.interfaces.Record;
import com.rvnu.models.thirdparty.draftkings.ContestEntryResult;
import com.rvnu.models.thirdparty.draftkings.EntryKey;
import com.rvnu.models.thirdparty.draftkings.Sport;
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
        INVALID_PLACES_PAID,
        COLUMN_DOES_NOT_EXIST,
    }

    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<Sport, Column, Error> sportDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryKey, Column, Error> entryKeyDeserializer;

    @Override
    public Either<Error, ContestEntryResult> deserialize(final Record<Column> record) {
        // for each column, get the value for that column
        // if no value exists, return column does not exist error
        // if value does exist, pass the value to the deserializer
        // if deserializer does not return a present value, return invalid column error
        return sportDeserializer.deserialize(record)
                .flatMap(sport -> entryKeyDeserializer.deserialize(record).flatMap(
                        entryKey -> {

                        }
                ));
    }
}
