package com.rvnu.data.thirdparty.fanduel.csv.records;

import com.rvnu.models.thirdparty.fanduel.contests.entries.*;
import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import com.rvnu.models.thirdparty.iso.PositiveInteger;
import junit.framework.TestCase;
import org.javamoney.moneta.Money;

import javax.money.Monetary;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

public class DeserializerTest extends TestCase {

    public void test() {
        final String firstTwoRows = """
                Entry Id,Sport,Date,Title,SalaryCap,Score,Opp Score,Position,Entries,Opponent,Entry ($),Winnings ($),Link
                S1995847859,nba,2020/02/21,$200K Fri NBA Shot Machine ($50K to 1st),$60k,320.60,,8161,30642,Tournament,7.77,0,/entry/CMEEISAUO,
                """;

        final Map<com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer.Error, PositiveInteger> result;
        try {
            result = Deserializer.getInstance()
                    .deserialize(
                            new ByteArrayInputStream(
                                    firstTwoRows.getBytes(StandardCharsets.UTF_8)
                            ),
                            contestEntryResult -> {
                                try {
                                    assertEquals(
                                            new Entry(
                                                    new EntryId(1995847859L),
                                                    Sport.NBA,
                                                    new StartDate(LocalDate.of(2020, Month.FEBRUARY, 21)),
                                                    new Name("$200K Fri NBA Shot Machine ($50K to 1st)"),
                                                    new SalaryCap(Money.of(60_000, Monetary.getCurrency("USD"))),
                                                    new BigDecimal("320.60"),
                                                    new PositiveInteger(8161),
                                                    new PositiveInteger(30642),
                                                    BigDecimal.valueOf(7.77),
                                                    BigDecimal.ZERO,
                                                    new EntryPathIdentifier("CMEEISAUO")
                                            ),
                                            contestEntryResult
                                    );
                                } catch (PositiveInteger.ValueMustBePositive | NaturalNumber.ValueMustNotBeNegative | NonNegativeMonetaryValue.ValueMustNotBeNegative | Name.InvalidValue e) {
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