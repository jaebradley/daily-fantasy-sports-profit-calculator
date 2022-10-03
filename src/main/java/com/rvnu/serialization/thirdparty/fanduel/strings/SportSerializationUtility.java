package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.Sport;
import com.rvnu.serialization.firstparty.strings.impl.AbstractEnumSerializationUtility;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SportSerializationUtility extends AbstractEnumSerializationUtility<Sport> {
    private static final SportSerializationUtility INSTANCE = new SportSerializationUtility(
            new EnumMap<Sport, String>(
                    Arrays.stream(Sport.values())
                            .map(v -> Map.entry(v, v.name().toLowerCase()))
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            )
    );

    private SportSerializationUtility(final EnumMap<Sport, String> serializationsByValue) {
        super(serializationsByValue);
    }

    public static SportSerializationUtility getInstance() {
        return INSTANCE;
    }
}
