package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.EntryKey;
import com.rvnu.serialization.thirdparty.draftkings.strings.EntryKeySerializationUtility;

public class EntryKeyDeserializer extends AbstractValueDeserializer<EntryKey, Deserializer.Column, Deserializer.Error> {
    private static final EntryKeyDeserializer INSTANCE = new EntryKeyDeserializer(
            EntryKeySerializationUtility.getInstance(),
            Deserializer.Column.ENTRY_KEY,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_ENTRY_KEY
    );

    private EntryKeyDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<EntryKey> contestEntriesDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(contestEntriesDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static EntryKeyDeserializer getInstance() {
        return INSTANCE;
    }
}
