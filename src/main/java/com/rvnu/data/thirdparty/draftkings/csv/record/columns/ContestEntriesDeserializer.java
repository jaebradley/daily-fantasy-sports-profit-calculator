package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.contests.entries.ContestEntries;
import com.rvnu.serialization.thirdparty.draftkings.strings.ContestEntriesSerializationUtility;

public class ContestEntriesDeserializer extends AbstractValueDeserializer<ContestEntries, Deserializer.Column, Deserializer.Error> {
    private static final ContestEntriesDeserializer INSTANCE = new ContestEntriesDeserializer(
            ContestEntriesSerializationUtility.getInstance()
    );

    private ContestEntriesDeserializer(
            com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<ContestEntries> contestEntriesDeserializer
    ) {
        super(
                contestEntriesDeserializer,
                Deserializer.Column.CONTEST_ENTRIES,
                Deserializer.Error.COLUMN_DOES_NOT_EXIST,
                Deserializer.Error.INVALID_CONTEST_ENTRIES
        );
    }

    public static ContestEntriesDeserializer getInstance() {
        return INSTANCE;
    }
}
