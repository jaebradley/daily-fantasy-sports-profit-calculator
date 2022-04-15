package com.rvnu.data.firstparty.csv.records.impl;

import com.rvnu.models.thirdparty.draftkings.ContestEntryResult;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.function.Consumer;

public class Deserializer implements com.rvnu.data.firstparty.csv.records.interfaces.Deserializer<ContestEntryResult> {
    private final Charset characterSet;
    private final CSVFormat format;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestEntryResult> resultDeserializer;

    public Deserializer(final Charset characterSet, final CSVFormat format, com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<ContestEntryResult> resultDeserializer) {
        this.characterSet = characterSet;
        this.format = format;
        this.resultDeserializer = resultDeserializer;
    }

    @Override
    public void deserialize(InputStream inputStream, Consumer<ContestEntryResult> contestEntryResultConsumer) throws UnableToDeserializeRecords {
        try (final CSVParser parser = CSVParser.parse(
                inputStream,
                characterSet,
                format
        )) {
            for (final CSVRecord record : parser) {
//                resultDeserializer.deserialize();
            }
        } catch (IOException e) {
            throw new UnableToDeserializeRecords();
        }
    }
}
