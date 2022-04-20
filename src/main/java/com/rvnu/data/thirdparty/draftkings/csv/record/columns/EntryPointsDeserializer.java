package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.contests.entries.EntryPoints;
import com.rvnu.serialization.thirdparty.draftkings.strings.EntryPointsSerializationUtility;

public class EntryPointsDeserializer extends AbstractValueDeserializer<EntryPoints, Deserializer.Column, Deserializer.Error> {
    private static final EntryPointsDeserializer INSTANCE = new EntryPointsDeserializer(
            EntryPointsSerializationUtility.getInstance(),
            Deserializer.Column.ENTRY_POINTS,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_ENTRY_POINTS
    );

    private EntryPointsDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<EntryPoints> contestEntriesDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(contestEntriesDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static EntryPointsDeserializer getInstance() {
        return INSTANCE;
    }
}
