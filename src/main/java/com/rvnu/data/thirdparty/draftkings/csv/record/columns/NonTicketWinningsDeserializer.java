package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.contests.entries.NonTicketWinnings;
import com.rvnu.serialization.thirdparty.draftkings.strings.NonTicketWinningsSerializationUtility;

public class NonTicketWinningsDeserializer extends AbstractValueDeserializer<NonTicketWinnings, Deserializer.Column, Deserializer.Error> {
    private static final NonTicketWinningsDeserializer INSTANCE = new NonTicketWinningsDeserializer(
            NonTicketWinningsSerializationUtility.getInstance(),
            Deserializer.Column.NON_TICKET_WINNINGS,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_NON_TICKET_WINNINGS
    );

    private NonTicketWinningsDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<NonTicketWinnings> contestEntriesDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(contestEntriesDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static NonTicketWinningsDeserializer getInstance() {
        return INSTANCE;
    }
}
