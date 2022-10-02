package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.Sport;
import com.rvnu.serialization.firstparty.strings.impl.AbstractEnumSerializationUtility;

import java.util.EnumMap;
import java.util.Map;

public class SportSerializationUtility extends AbstractEnumSerializationUtility<Sport> {
    private static final SportSerializationUtility INSTANCE = new SportSerializationUtility(
            new EnumMap<Sport, String>(
                    Map.of(Sport.nba, "nba")
            )
    );

    private SportSerializationUtility(final EnumMap<Sport, String> serializationsByValue) {
        super(serializationsByValue);
    }

    public static SportSerializationUtility getInstance() {
        return INSTANCE;
    }
}
