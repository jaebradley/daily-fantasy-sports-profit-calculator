package com.rvnu.data.thirdparty.fanduel.csv.record.impl;

import com.rvnu.data.firstparty.csv.record.columns.BigDecimalDeserializer;
import com.rvnu.data.firstparty.csv.record.columns.PositiveIntegerDeserializer;
import com.rvnu.data.firstparty.csv.record.interfaces.Record;
import com.rvnu.data.thirdparty.fanduel.csv.record.columns.*;
import com.rvnu.models.thirdparty.fanduel.contests.entries.*;
import com.rvnu.models.thirdparty.iso.PositiveInteger;
import io.vavr.control.Either;

import java.math.BigDecimal;

public class Deserializer implements com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<
        Entry,
        Deserializer.Column,
        Deserializer.Error
        > {

    public static Deserializer getInstance() {
        return INSTANCE;
    }

    public enum Column {
        ENTRY_ID,
        SPORT,
        START_DATE,
        NAME,
        SALARY_CAP,
        SCORE,
        OPPOSING_SCORE,
        CONTEST_PLACE,
        ENTRY_COUNT,
        OPPONENT,
        ENTRY_FEE,
        WINNINGS,
        ENTRY_PATH_IDENTIFIER,
    }

    public enum Error {
        INVALID_ENTRY_ID,
        INVALID_SPORT,
        INVALID_START_DATE,
        INVALID_NAME,
        INVALID_SALARY_CAP,
        INVALID_SCORE,
        INVALID_OPPOSING_SCORE,
        INVALID_CONTEST_PLACE,
        INVALID_ENTRY_COUNT,
        INVALID_OPPONENT,
        INVALID_ENTRY_FEE,
        INVALID_WINNINGS,
        INVALID_ENTRY_PATH_IDENTIFIER,
        COLUMN_DOES_NOT_EXIST,
    }

    private static final Deserializer INSTANCE = new Deserializer(
            EntryIdDeserializer.getInstance(),
            SportDeserializer.getInstance(),
            StartDateDeserializer.getInstance(),
            NameDeserializer.getInstance(),
            SalaryCapDeserializer.getInstance(),
            new BigDecimalDeserializer<>(Column.SCORE, Error.COLUMN_DOES_NOT_EXIST, Error.INVALID_SCORE),
            new PositiveIntegerDeserializer<>(Column.CONTEST_PLACE, Error.COLUMN_DOES_NOT_EXIST, Error.INVALID_CONTEST_PLACE),
            new PositiveIntegerDeserializer<>(Column.ENTRY_COUNT, Error.COLUMN_DOES_NOT_EXIST, Error.INVALID_ENTRY_COUNT),
            new BigDecimalDeserializer<>(Column.ENTRY_FEE, Error.COLUMN_DOES_NOT_EXIST, Error.INVALID_ENTRY_FEE),
            new BigDecimalDeserializer<>(Column.WINNINGS, Error.COLUMN_DOES_NOT_EXIST, Error.INVALID_WINNINGS),
            EntryPathIdentifierDeserializer.getInstance()
    );

    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryId, Column, Error> entryIdDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<Sport, Column, Error> sportDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<StartDate, Column, Error> startDateDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<Name, Column, Error> nameDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<SalaryCap, Column, Error> salaryCapDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<BigDecimal, Column, Error> scoreDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<PositiveInteger, Column, Error> contestPlaceDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<PositiveInteger, Column, Error> entryCountDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<BigDecimal, Column, Error> entryFeeDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<BigDecimal, Column, Error> winningsDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryPathIdentifier, Column, Error> entryPathIdentifierDeserializer;

    private Deserializer(
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryId, Column, Error> entryIdDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<Sport, Column, Error> sportDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<StartDate, Column, Error> startDateDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<Name, Column, Error> nameDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<SalaryCap, Column, Error> salaryCapDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<BigDecimal, Column, Error> scoreDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<PositiveInteger, Column, Error> contestPlaceDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<PositiveInteger, Column, Error> entryCountDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<BigDecimal, Column, Error> entryFeeDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<BigDecimal, Column, Error> winningsDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryPathIdentifier, Column, Error> entryPathIdentifierDeserializer) {
        this.entryIdDeserializer = entryIdDeserializer;
        this.sportDeserializer = sportDeserializer;
        this.startDateDeserializer = startDateDeserializer;
        this.nameDeserializer = nameDeserializer;
        this.salaryCapDeserializer = salaryCapDeserializer;
        this.scoreDeserializer = scoreDeserializer;
        this.contestPlaceDeserializer = contestPlaceDeserializer;
        this.entryCountDeserializer = entryCountDeserializer;
        this.entryFeeDeserializer = entryFeeDeserializer;
        this.winningsDeserializer = winningsDeserializer;
        this.entryPathIdentifierDeserializer = entryPathIdentifierDeserializer;
    }


    @Override
    public Either<Error, Entry> deserialize(final Record<Column> record) {
        return entryIdDeserializer.deserialize(record)
                .flatMap(entryId -> sportDeserializer.deserialize(record)
                        .flatMap(sport -> startDateDeserializer.deserialize(record)
                                .flatMap(startDate -> nameDeserializer.deserialize(record)
                                        .flatMap(name -> salaryCapDeserializer.deserialize(record)
                                                .flatMap(salaryCap -> scoreDeserializer.deserialize(record)
                                                        .flatMap(score -> contestPlaceDeserializer.deserialize(record)
                                                                .flatMap(place -> entryCountDeserializer.deserialize(record)
                                                                        .flatMap(count -> entryFeeDeserializer.deserialize(record)
                                                                                .flatMap(fee -> winningsDeserializer.deserialize(record)
                                                                                        .flatMap(winnings -> entryPathIdentifierDeserializer.deserialize(record)
                                                                                                .map(entryPathIdentifier -> new Entry(
                                                                                                        entryId,
                                                                                                        sport,
                                                                                                        startDate,
                                                                                                        name,
                                                                                                        salaryCap,
                                                                                                        score,
                                                                                                        place,
                                                                                                        count,
                                                                                                        fee,
                                                                                                        winnings,
                                                                                                        entryPathIdentifier
                                                                                                ))))))))))));
    }
}
