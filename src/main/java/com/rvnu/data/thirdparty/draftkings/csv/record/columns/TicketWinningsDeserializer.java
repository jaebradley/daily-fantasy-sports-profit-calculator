package com.rvnu.data.thirdparty.draftkings.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.draftkings.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.draftkings.contests.entries.TicketWinnings;
import com.rvnu.serialization.thirdparty.draftkings.strings.TicketWinningsSerializationUtility;

public class TicketWinningsDeserializer extends AbstractValueDeserializer<TicketWinnings, Deserializer.Column, Deserializer.Error> {
    private static final TicketWinningsDeserializer INSTANCE = new TicketWinningsDeserializer(
            TicketWinningsSerializationUtility.getInstance(),
            Deserializer.Column.TICKET_WINNINGS,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_TICKET_WINNINGS
    );

    private TicketWinningsDeserializer(
            final com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<TicketWinnings> contestEntriesDeserializer,
            final Deserializer.Column column,
            final Deserializer.Error columnDoesNotExistError,
            final Deserializer.Error invalidValueError
    ) {
        super(contestEntriesDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static TicketWinningsDeserializer getInstance() {
        return INSTANCE;
    }
}
