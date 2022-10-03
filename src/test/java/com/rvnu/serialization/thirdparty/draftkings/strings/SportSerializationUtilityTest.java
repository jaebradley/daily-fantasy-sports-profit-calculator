package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.contests.entries.Sport;
import junit.framework.TestCase;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class SportSerializationUtilityTest extends TestCase {

    public void test() {
        Stream.of(
                Map.entry(Sport.Basketball, "NBA")
        ).forEach(e -> {
            assertEquals(Optional.of(e.getKey()), SportSerializationUtility.getInstance().deserialize(e.getValue()));
            assertEquals(e.getValue(), SportSerializationUtility.getInstance().serialize(e.getKey()));
        });

        Stream.of(
                "foo",
                "",
                "nba"
        ).forEach(v -> assertTrue(SportSerializationUtility.getInstance().deserialize(v).isEmpty()));
    }
}