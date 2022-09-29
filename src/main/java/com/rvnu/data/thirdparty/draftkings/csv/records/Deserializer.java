package com.rvnu.data.thirdparty.draftkings.csv.records;

import com.rvnu.data.firstparty.csv.records.impl.AbstractDeserializer;
import com.rvnu.models.thirdparty.draftkings.contests.entries.ContestEntryResult;
import org.apache.commons.csv.CSVFormat;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Deserializer extends AbstractDeserializer<ContestEntryResult, com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer.Column, com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer.Error> {
    private static final Deserializer INSTANCE = new Deserializer(
            StandardCharsets.UTF_8,
            CSVFormat.DEFAULT
                    .builder()
                    .setHeader("\"Sport\",\"Game_Type\",\"Entry_Key\",\"Entry\",\"Contest_Key\",\"Contest_Date_EST\",\"Place\",\"Points\",\"Winnings_Non_Ticket\",\"Winnings_Ticket\",\"Contest_Entries\",\"Entry_Fee\",\"Prize_Pool\",\"Places_Paid\"")
                    .setSkipHeaderRecord(true)
                    .build(),
            com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer.getInstance()
    );

    private Deserializer(
            final Charset characterSet,
            final CSVFormat format,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestEntryResult, com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer.Column, com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer.Error> resultDeserializer
    ) {
        super(characterSet, format, resultDeserializer);
    }

    public static Deserializer getInstance() {
        return INSTANCE;
    }
}
