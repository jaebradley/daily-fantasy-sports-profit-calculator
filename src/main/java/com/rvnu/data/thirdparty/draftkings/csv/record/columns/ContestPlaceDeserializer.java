package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.ContestPlace;
import com.rvnu.serialization.thirdparty.draftkings.strings.ContestPlaceSerializationUtility;

public class ContestPlaceDeserializer extends AbstractValueDeserializer<ContestPlace, Deserializer.Column, Deserializer.Error> {
    private static final ContestPlaceDeserializer INSTANCE = new ContestPlaceDeserializer(
            ContestPlaceSerializationUtility.getInstance(),
            Deserializer.Column.CONTEST_PLACE,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_CONTEST_PLACE
    );

    private ContestPlaceDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<ContestPlace> contestEntriesDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(contestEntriesDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static ContestPlaceDeserializer getInstance() {
        return INSTANCE;
    }
}
