package com.rvnu.data.thirdparty.fanduel.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.fanduel.contests.entries.EntryId;
import com.rvnu.serialization.thirdparty.fanduel.strings.EntryIdSerializationUtility;

public class EntryIdDeserializer extends AbstractValueDeserializer<EntryId, Deserializer.Column, Deserializer.Error> {
    private static final EntryIdDeserializer INSTANCE = new EntryIdDeserializer(
            EntryIdSerializationUtility.getInstance(), Deserializer.Column.ENTRY_ID, Deserializer.Error.COLUMN_DOES_NOT_EXIST, Deserializer.Error.INVALID_ENTRY_ID
    );

    private EntryIdDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<EntryId> entryIdDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(entryIdDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static EntryIdDeserializer getInstance() {
        return INSTANCE;
    }
}
