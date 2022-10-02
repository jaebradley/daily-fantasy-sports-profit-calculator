package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.ContestType;
import com.rvnu.serialization.firstparty.strings.impl.AbstractEnumSerializationUtility;

import java.util.EnumMap;
import java.util.Map;

public class ContestTypeSerializationUtility extends AbstractEnumSerializationUtility<ContestType> {
    private static final ContestTypeSerializationUtility INSTANCE = new ContestTypeSerializationUtility(
            new EnumMap<ContestType, String>(
                    Map.of(
                            ContestType.Cancelled, "Cancelled",
                            ContestType.Tournament, "Tournament",
                            ContestType._20_player_league, "20 player league"
                    )
            )
    );

    private ContestTypeSerializationUtility(final EnumMap<ContestType, String> serializationsByValue) {
        super(serializationsByValue);
    }

    public static ContestTypeSerializationUtility getInstance() {
        return INSTANCE;
    }
}
