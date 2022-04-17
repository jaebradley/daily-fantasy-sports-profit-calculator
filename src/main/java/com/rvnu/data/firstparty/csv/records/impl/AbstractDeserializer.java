package com.rvnu.data.firstparty.csv.records.impl;

import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.models.thirdparty.iso.PositiveInteger;
import io.vavr.control.Either;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class AbstractDeserializer<Result, Column extends Enum<Column>, Error extends Enum<Error>> implements com.rvnu.data.firstparty.csv.records.interfaces.Deserializer<Result, Error> {
    private final Charset characterSet;
    private final CSVFormat format;
    private final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<Result, Column, Error> resultDeserializer;

    protected AbstractDeserializer(
            final Charset characterSet,
            final CSVFormat format,
            final com.rvnu.data.firstparty.csv.record.interfaces.Deserializer<Result, Column, Error> resultDeserializer
    ) {
        this.characterSet = characterSet;
        this.format = format;
        this.resultDeserializer = resultDeserializer;
    }

    @Override
    public Map<Error, PositiveInteger> deserialize(InputStream inputStream, Consumer<Result> resultConsumer) throws UnableToDeserializeRecords {
        final Map<Error, PositiveInteger> countsByError = new HashMap<>();

        try (final CSVParser parser = CSVParser.parse(
                inputStream,
                characterSet,
                format
        )) {
            for (final CSVRecord record : parser) {
                final Either<Error, Result> deserializationResult = resultDeserializer.deserialize(
                        column -> Optional.ofNullable(record.get(column.ordinal()))
                );

                if (deserializationResult.isLeft()) {
                    countsByError.merge(deserializationResult.getLeft(), PositiveInteger.ONE, (positiveInteger, positiveInteger2) -> {
                        try {
                            return new PositiveInteger(positiveInteger.getValue() + positiveInteger2.getValue());
                        } catch (PositiveInteger.ValueMustBePositive | NaturalNumber.ValueMustNotBeNegative e) {
                            throw new IllegalStateException();
                        }
                    });
                } else {
                    resultConsumer.accept(deserializationResult.get());
                }
            }
        } catch (IOException e) {
            throw new UnableToDeserializeRecords();
        }

        return countsByError;
    }
}
