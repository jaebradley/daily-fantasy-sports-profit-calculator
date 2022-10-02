package com.rvnu.data.thirdparty.fanduel.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.fanduel.contests.entries.StartDate;
import com.rvnu.serialization.thirdparty.fanduel.strings.StartDateSerializationUtility;

public class StartDateDeserializer extends AbstractValueDeserializer<StartDate, Deserializer.Column, Deserializer.Error> {
    private static final StartDateDeserializer INSTANCE = new StartDateDeserializer(
            StartDateSerializationUtility.getInstance(),
            Deserializer.Column.START_DATE,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_START_DATE
    );

    private StartDateDeserializer(com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<StartDate> startDateDeserializer, Deserializer.Column column, Deserializer.Error columnDoesNotExistError, Deserializer.Error invalidValueError) {
        super(startDateDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static StartDateDeserializer getInstance() {
        return INSTANCE;
    }
}
