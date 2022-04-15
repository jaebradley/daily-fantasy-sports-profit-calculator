package com.rvnu.data.firstparty.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.interfaces.Deserializer;
import com.rvnu.data.firstparty.csv.record.interfaces.Record;
import io.vavr.control.Either;

public abstract class AbstractValueDeserializer<Value, Column extends Enum<?>, Error extends Enum<?>> implements Deserializer<Value, Column, Error> {
    private final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<Value> valueDeserializer;
    private final Column column;
    private final Error columnDoesNotExistError;
    private final Error invalidValueError;

    public AbstractValueDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<Value> contestEntriesDeserializer,
            final Column column,
            final Error columnDoesNotExistError,
            final Error invalidValueError
    ) {
        this.valueDeserializer = contestEntriesDeserializer;
        this.column = column;
        this.columnDoesNotExistError = columnDoesNotExistError;
        this.invalidValueError = invalidValueError;
    }

    @Override
    public Either<Error, Value> deserialize(final Record<Column> record) {
        return record.getValue(column)
                .map(v -> valueDeserializer
                        .deserialize(v)
                        .map(Either::<Error, Value>right)
                        .orElseGet(() -> Either.left(invalidValueError)))
                .orElseGet(() -> Either.left(columnDoesNotExistError));
    }
}
