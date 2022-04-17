package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.ContestKey;
import com.rvnu.serialization.thirdparty.draftkings.strings.ContestKeySerializationUtility;

public class ContestKeyDeserializer extends AbstractValueDeserializer<ContestKey, Deserializer.Column, Deserializer.Error> {
    private static final ContestKeyDeserializer INSTANCE = new ContestKeyDeserializer(
            ContestKeySerializationUtility.getInstance(),
            Deserializer.Column.CONTEST_KEY,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_CONTEST_KEY
    );

    private ContestKeyDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<ContestKey> contestEntriesDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(contestEntriesDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static ContestKeyDeserializer getInstance() {
        return INSTANCE;
    }
}
