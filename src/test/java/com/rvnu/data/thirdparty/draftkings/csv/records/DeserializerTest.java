package com.rvnu.data.thirdparty.draftkings.csv.records;

import com.rvnu.models.thirdparty.draftkings.contests.entries.*;
import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import com.rvnu.models.thirdparty.iso.PositiveInteger;
import junit.framework.TestCase;
import org.javamoney.moneta.Money;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;

public class DeserializerTest extends TestCase {

    public void test() {
        final String firstTwoRows = "\"Sport\",\"Game_Type\",\"Entry_Key\",\"Entry\",\"Contest_Key\",\"Contest_Date_EST\",\"Place\",\"Points\",\"Winnings_Non_Ticket\",\"Winnings_Ticket\",\"Contest_Entries\",\"Entry_Fee\",\"Prize_Pool\",\"Places_Paid\"\n" +
                "\"NFL\",\"Classic\",3049390519,\"NFL $5 Double Up (Sat)\",121304070,\"2021-12-25 16:30:00\",321,119.38,\"$0.00\",\"$0.00\",344,\"$5.00\",\"$1,500.00\",150\n";

        try {
            Deserializer.getInstance()
                    .deserialize(
                            new ByteArrayInputStream(
                                    firstTwoRows.getBytes(StandardCharsets.UTF_8)
                            ),
                            contestEntryResult -> {
                                try {
                                    assertEquals(
                                            new ContestEntryResult(
                                                    Sport.NFL,
                                                    new EntryKey(3049390519L),
                                                    new ContestKey(121304070L),
                                                    new ContestStartTime(Instant.parse("2021-12-25 16:30:00").atZone(ZoneId.of("America/New_York")).toInstant()),
                                                    new ContestPlace(321),
                                                    new EntryPoints(BigDecimal.valueOf(119.38)),
                                                    new Winnings(
                                                            new NonTicketWinnings(Money.parse("$0.00")),
                                                            new TicketWinnings(Money.parse("$0.00"))
                                                    ),
                                                    new ContestEntries(344),
                                                    new EntryFee(Money.parse("$5.00")),
                                                    new PrizePool(Money.parse("$1,500.00")),
                                                    new PlacesPaid(150)
                                            ),
                                            contestEntryResult
                                    );
                                } catch (PositiveInteger.ValueMustBePositive | NaturalNumber.ValueMustNotBeNegative | NonNegativeMonetaryValue.ValueMustNotBeNegative e) {
                                    fail();
                                }
                            }
                    );
        } catch (com.rvnu.data.firstparty.csv.records.interfaces.Deserializer.UnableToDeserializeRecords e) {
            fail();
        }
    }
}