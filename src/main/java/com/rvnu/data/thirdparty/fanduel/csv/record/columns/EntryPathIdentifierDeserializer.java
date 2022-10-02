package com.rvnu.data.thirdparty.fanduel.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.fanduel.contests.entries.EntryPathIdentifier;
import com.rvnu.serialization.thirdparty.fanduel.strings.EntryPathIdentifierSerializationUtility;

public class EntryPathIdentifierDeserializer extends AbstractValueDeserializer<EntryPathIdentifier, Deserializer.Column, Deserializer.Error> {
    private static final EntryPathIdentifierDeserializer INSTANCE = new EntryPathIdentifierDeserializer(
            EntryPathIdentifierSerializationUtility.getInstance(),
            Deserializer.Column.ENTRY_PATH_IDENTIFIER,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_ENTRY_PATH_IDENTIFIER
    );

    private EntryPathIdentifierDeserializer(com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<EntryPathIdentifier> entryPathIdentifierDeserializer, Deserializer.Column column, Deserializer.Error columnDoesNotExistError, Deserializer.Error invalidValueError) {
        super(entryPathIdentifierDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static EntryPathIdentifierDeserializer getInstance() {
        return INSTANCE;
    }
}
