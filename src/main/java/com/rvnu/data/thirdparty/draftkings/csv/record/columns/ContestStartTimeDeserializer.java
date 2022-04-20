package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.contests.entries.ContestStartTime;
import com.rvnu.serialization.thirdparty.draftkings.strings.ContestStartTimeSerializationUtility;

public class ContestStartTimeDeserializer extends AbstractValueDeserializer<ContestStartTime, Deserializer.Column, Deserializer.Error> {
    private static final ContestStartTimeDeserializer INSTANCE = new ContestStartTimeDeserializer(
            ContestStartTimeSerializationUtility.getInstance(),
            Deserializer.Column.CONTEST_START_TIME,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_CONTEST_START_TIME
    );

    private ContestStartTimeDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<ContestStartTime> contestEntriesDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(contestEntriesDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static ContestStartTimeDeserializer getInstance() {
        return INSTANCE;
    }
}
