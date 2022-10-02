package com.rvnu.data.thirdparty.fanduel.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.fanduel.contests.entries.Name;

import java.util.Optional;

public class NameDeserializer extends AbstractValueDeserializer<Name, Deserializer.Column, Deserializer.Error> {
    private static final NameDeserializer INSTANCE = new NameDeserializer(
            // TODO: @jbradley move this to own serialization utility
            value -> {
                try {
                    return Optional.of(new Name(value));
                } catch (Name.InvalidValue e) {
                    return Optional.empty();
                }
            },
            Deserializer.Column.NAME,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_NAME
    );

    private NameDeserializer(com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<Name> nameDeserializer, Deserializer.Column column, Deserializer.Error columnDoesNotExistError, Deserializer.Error invalidValueError) {
        super(nameDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static NameDeserializer getInstance() {
        return INSTANCE;
    }
}
