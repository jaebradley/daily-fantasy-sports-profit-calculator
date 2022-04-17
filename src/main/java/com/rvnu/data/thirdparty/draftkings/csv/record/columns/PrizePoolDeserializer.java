package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.PrizePool;
import com.rvnu.serialization.thirdparty.draftkings.strings.PrizePoolSerializationUtility;

public class PrizePoolDeserializer extends AbstractValueDeserializer<PrizePool, Deserializer.Column, Deserializer.Error> {
    private static final PrizePoolDeserializer INSTANCE = new PrizePoolDeserializer(
            PrizePoolSerializationUtility.getInstance(),
            Deserializer.Column.PRIZE_POOL,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_PRIZE_POOL
    );

    private PrizePoolDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<PrizePool> prizePoolDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(prizePoolDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static PrizePoolDeserializer getInstance() {
        return INSTANCE;
    }
}
