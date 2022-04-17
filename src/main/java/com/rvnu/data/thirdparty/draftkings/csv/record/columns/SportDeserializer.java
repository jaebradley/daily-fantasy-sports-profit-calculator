package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.Sport;
import com.rvnu.serialization.thirdparty.draftkings.strings.SportSerializationUtility;

public class SportDeserializer extends AbstractValueDeserializer<Sport, Deserializer.Column, Deserializer.Error> {
    private static final SportDeserializer INSTANCE = new SportDeserializer(
            SportSerializationUtility.getInstance(),
            Deserializer.Column.SPORT,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_SPORT
    );

    private SportDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<Sport> contestEntriesDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(contestEntriesDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static SportDeserializer getInstance() {
        return INSTANCE;
    }
}
