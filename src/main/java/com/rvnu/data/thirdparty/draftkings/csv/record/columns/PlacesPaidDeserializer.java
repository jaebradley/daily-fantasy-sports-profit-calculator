package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.PlacesPaid;
import com.rvnu.serialization.thirdparty.draftkings.strings.PlacesPaidSerializationUtility;

public class PlacesPaidDeserializer extends AbstractValueDeserializer<PlacesPaid, Deserializer.Column, Deserializer.Error> {
    private static final PlacesPaidDeserializer INSTANCE = new PlacesPaidDeserializer(
            PlacesPaidSerializationUtility.getInstance(),
            Deserializer.Column.PLACES_PAID,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_PLACES_PAID
    );

    private PlacesPaidDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<PlacesPaid> placesPaidDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(placesPaidDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static PlacesPaidDeserializer getInstance() {
        return INSTANCE;
    }
}
