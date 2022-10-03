package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.Sport;
import junit.framework.TestCase;

import java.util.Optional;
import java.util.stream.Stream;

public class SportSerializationUtilityTest extends TestCase {
    public void test() {
        assertEquals(Optional.of(Sport.NBA), SportSerializationUtility.getInstance().deserialize("nba"));
        assertEquals("nba", SportSerializationUtility.getInstance().serialize(Sport.NBA));

        Stream.of(
                "",
                "NBA",
                "JAE"
        ).forEach(v -> assertTrue(SportSerializationUtility.getInstance().deserialize(v).isEmpty()));
    }
}