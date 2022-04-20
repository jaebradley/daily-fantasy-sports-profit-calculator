package com.rvnu.data.thirdparty.draftkings.csv.record.impl;

import com.rvnu.data.firstparty.csv.record.interfaces.Record;
import com.rvnu.data.thirdparty.draftkings.csv.record.columns.*;
import com.rvnu.models.thirdparty.draftkings.contests.entries.*;
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
        ENTRY_NAME,
        CONTEST_KEY,
        CONTEST_START_TIME,
        CONTEST_PLACE,
        ENTRY_POINTS,
        NON_TICKET_WINNINGS,
        TICKET_WINNINGS,
        CONTEST_ENTRIES,
        ENTRY_FEE,
        PRIZE_POOL,
        PLACES_PAID,
    }


    public enum Error {
        INVALID_SPORT,
        INVALID_GAME_TYPE,
        INVALID_ENTRY_KEY,
        INVALID_ENTRY_NAME,
        INVALID_CONTEST_KEY,
        INVALID_CONTEST_START_TIME,
        INVALID_CONTEST_PLACE,
        INVALID_ENTRY_POINTS,
        INVALID_NON_TICKET_WINNINGS,
        INVALID_TICKET_WINNINGS,
        INVALID_CONTEST_ENTRIES,
        INVALID_ENTRY_FEE,
        INVALID_PRIZE_POOL,
        INVALID_PLACES_PAID,
        COLUMN_DOES_NOT_EXIST,
    }

    private static final Deserializer INSTANCE = new Deserializer(
            SportDeserializer.getInstance(),
            EntryKeyDeserializer.getInstance(),
            ContestKeyDeserializer.getInstance(),
            ContestStartTimeDeserializer.getInstance(),
            ContestPlaceDeserializer.getInstance(),
            EntryPointsDeserializer.getInstance(),
            NonTicketWinningsDeserializer.getInstance(),
            TicketWinningsDeserializer.getInstance(),
            ContestEntriesDeserializer.getInstance(),
            EntryFeeDeserializer.getInstance(),
            PrizePoolDeserializer.getInstance(),
            PlacesPaidDeserializer.getInstance()
    );

    // TODO: @jbradley check unused column values for appropriate format
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<Sport, Column, Error> sportDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryKey, Column, Error> entryKeyDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestKey, Column, Error> contestKeyDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestStartTime, Column, Error> startTimeDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestPlace, Column, Error> contestPlaceDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryPoints, Column, Error> entryPointsDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<NonTicketWinnings, Column, Error> nonTicketWinningsDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<TicketWinnings, Column, Error> ticketWinningsDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestEntries, Column, Error> contestEntriesDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryFee, Column, Error> entryFeeDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<PrizePool, Column, Error> prizePoolDeserializer;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<PlacesPaid, Column, Error> placesPaidDeserializer;

    private Deserializer(
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<Sport, Column, Error> sportDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryKey, Column, Error> entryKeyDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestKey, Column, Error> contestKeyDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestStartTime, Column, Error> startTimeDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestPlace, Column, Error> contestPlaceDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryPoints, Column, Error> entryPointsDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<NonTicketWinnings, Column, Error> nonTicketWinningsDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<TicketWinnings, Column, Error> ticketWinningsDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestEntries, Column, Error> contestEntriesDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<EntryFee, Column, Error> entryFeeDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<PrizePool, Column, Error> prizePoolDeserializer,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<PlacesPaid, Column, Error> placesPaidDeserializer
    ) {
        this.sportDeserializer = sportDeserializer;
        this.entryKeyDeserializer = entryKeyDeserializer;
        this.contestKeyDeserializer = contestKeyDeserializer;
        this.startTimeDeserializer = startTimeDeserializer;
        this.contestPlaceDeserializer = contestPlaceDeserializer;
        this.entryPointsDeserializer = entryPointsDeserializer;
        this.nonTicketWinningsDeserializer = nonTicketWinningsDeserializer;
        this.ticketWinningsDeserializer = ticketWinningsDeserializer;
        this.contestEntriesDeserializer = contestEntriesDeserializer;
        this.entryFeeDeserializer = entryFeeDeserializer;
        this.prizePoolDeserializer = prizePoolDeserializer;
        this.placesPaidDeserializer = placesPaidDeserializer;
    }

    @Override
    public Either<Error, ContestEntryResult> deserialize(final Record<Column> record) {
        // for each column, get the value for that column
        // if no value exists, return column does not exist error
        // if value does exist, pass the value to the deserializer
        // if deserializer does not return a present value, return invalid column error
        return sportDeserializer.deserialize(record)
                .flatMap(sport -> entryKeyDeserializer.deserialize(record).flatMap(
                        entryKey -> contestKeyDeserializer.deserialize(record).flatMap(
                                contestKey -> startTimeDeserializer.deserialize(record).flatMap(
                                        startTime -> contestPlaceDeserializer.deserialize(record).flatMap(
                                                place -> entryPointsDeserializer.deserialize(record).flatMap(
                                                        points -> nonTicketWinningsDeserializer.deserialize(record).flatMap(
                                                                nonTicketWinnings -> ticketWinningsDeserializer.deserialize(record).flatMap(
                                                                        ticketWinnings -> contestEntriesDeserializer.deserialize(record).flatMap(
                                                                                contestEntries -> entryFeeDeserializer.deserialize(record).flatMap(
                                                                                        entryFee -> prizePoolDeserializer.deserialize(record).flatMap(
                                                                                                prizePool -> placesPaidDeserializer.deserialize(record).map(
                                                                                                        placesPaid ->
                                                                                                                new ContestEntryResult(
                                                                                                                        sport,
                                                                                                                        entryKey,
                                                                                                                        contestKey,
                                                                                                                        startTime,
                                                                                                                        place,
                                                                                                                        points,
                                                                                                                        new Winnings(
                                                                                                                                nonTicketWinnings,
                                                                                                                                ticketWinnings
                                                                                                                        ),
                                                                                                                        contestEntries,
                                                                                                                        entryFee,
                                                                                                                        prizePool,
                                                                                                                        placesPaid
                                                                                                                )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ));
    }

    public static Deserializer getInstance() {
        return INSTANCE;
    }
}
