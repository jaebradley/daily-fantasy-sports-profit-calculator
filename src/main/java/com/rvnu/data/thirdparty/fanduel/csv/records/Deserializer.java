package com.rvnu.data.thirdparty.fanduel.csv.records;

import com.rvnu.data.firstparty.csv.records.impl.AbstractDeserializer;
import com.rvnu.models.thirdparty.fanduel.contests.entries.Entry;
import org.apache.commons.csv.CSVFormat;

import java.nio.charset.StandardCharsets;

public class Deserializer extends AbstractDeserializer<Entry, com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer.Column, com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer.Error> {
    private static final Deserializer INSTANCE = new Deserializer();

    private Deserializer() {
        super(StandardCharsets.UTF_8,
                CSVFormat.DEFAULT
                        .builder()
                        .setHeader(com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer.Column.class)
                        .setSkipHeaderRecord(true)
                        .build(),
                com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer.getInstance());
    }

    public static Deserializer getInstance() {
        return INSTANCE;
    }
}
