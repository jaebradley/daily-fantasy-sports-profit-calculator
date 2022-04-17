package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.EntryFee;
import com.rvnu.serialization.thirdparty.draftkings.strings.EntryFeeSerializationUtility;

public class EntryFeeDeserializer extends AbstractValueDeserializer<EntryFee, Deserializer.Column, Deserializer.Error> {
    private static final EntryFeeDeserializer INSTANCE = new EntryFeeDeserializer(
            EntryFeeSerializationUtility.getInstance(),
            Deserializer.Column.ENTRY_FEE,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_ENTRY_FEE
    );

    private EntryFeeDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<EntryFee> entryFeeDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(entryFeeDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static EntryFeeDeserializer getInstance() {
        return INSTANCE;
    }
}
