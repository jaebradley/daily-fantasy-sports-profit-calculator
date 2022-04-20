package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.contests.entries.Sport;
import com.rvnu.serialization.firstparty.strings.impl.AbstractEnumSerializationUtility;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SportSerializationUtility extends AbstractEnumSerializationUtility<Sport> {
    private static final SportSerializationUtility INSTANCE = new SportSerializationUtility(
            new EnumMap<>(
                    Arrays.stream(Sport.values())
                            .collect(
                                    Collectors.toUnmodifiableMap(
                                            Function.identity(),
                                            Enum::name
                                    )
                            )
            )
    );

    private SportSerializationUtility(final EnumMap<Sport, String> serializationsByValue) {
        super(serializationsByValue);
    }

    public static SportSerializationUtility getInstance() {
        return INSTANCE;
    }
}
