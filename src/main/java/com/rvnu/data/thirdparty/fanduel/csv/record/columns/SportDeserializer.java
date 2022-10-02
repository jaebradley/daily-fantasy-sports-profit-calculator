package com.rvnu.data.thirdparty.fanduel.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.fanduel.contests.entries.Sport;
import com.rvnu.serialization.thirdparty.fanduel.strings.SportSerializationUtility;

public class SportDeserializer extends AbstractValueDeserializer<Sport, Deserializer.Column, Deserializer.Error> {
    private static final SportDeserializer INSTANCE = new SportDeserializer(
            SportSerializationUtility.getInstance(),
            Deserializer.Column.SPORT,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_SPORT
    );

    private SportDeserializer(com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<Sport> sportDeserializer, Deserializer.Column column, Deserializer.Error columnDoesNotExistError, Deserializer.Error invalidValueError) {
        super(sportDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static SportDeserializer getInstance() {
        return INSTANCE;
    }
}
