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
import java.time.ZonedDateTime;
import java.util.Map;

public class DeserializerTest extends TestCase {

    public void test() {
        final String firstTwoRows = """
                "Sport","Game_Type","Entry_Key","Entry","Contest_Key","Contest_Date_EST","Place","Points","Winnings_Non_Ticket","Winnings_Ticket","Contest_Entries","Entry_Fee","Prize_Pool","Places_Paid"
                "NFL","Classic",3049390519,"NFL $5 Double Up (Sat)",121304070,"2021-12-25 16:30:00",321,119.38,"$0.00","$0.00",344,"$5.00","$1,500.00",150
                """;

        final Map<com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer.Error, PositiveInteger> result;
        try {
            result = Deserializer.getInstance()
                    .deserialize(
                            new ByteArrayInputStream(
                                    firstTwoRows.getBytes(StandardCharsets.UTF_8)
                            ),
                            contestEntryResult -> {
                                try {
                                    assertEquals(
                                            new ContestEntryResult(
                                                    Sport.Football,
                                                    new EntryKey(3049390519L),
                                                    new ContestKey(121304070L),
                                                    new ContestStartTime(ZonedDateTime.parse("2021-12-25T16:30:00-05:00[America/New_York]")),
                                                    new ContestPlace(321),
                                                    new EntryPoints(BigDecimal.valueOf(119.38)),
                                                    new Winnings(
                                                            new NonTicketWinnings(Money.parse("USD 0.00")),
                                                            new TicketWinnings(Money.parse("USD 0.00"))
                                                    ),
                                                    new ContestEntries(344),
                                                    new EntryFee(Money.parse("USD 5.00")),
                                                    new PrizePool(Money.parse("USD 1500.00")),
                                                    new PlacesPaid(150)
                                            ),
                                            contestEntryResult
                                    );
                                } catch (PositiveInteger.ValueMustBePositive | NaturalNumber.ValueMustNotBeNegative | NonNegativeMonetaryValue.ValueMustNotBeNegative e) {
                                    throw new RuntimeException("unexpected", e);
                                }
                            }
                    );
        } catch (com.rvnu.data.firstparty.csv.records.interfaces.Deserializer.UnableToDeserializeRecords e) {
            throw new RuntimeException("unexpected", e);
        }

        assertTrue(result.isEmpty());
    }
}