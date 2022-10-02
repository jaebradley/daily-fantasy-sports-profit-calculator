package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.EntryPathIdentifier;
import junit.framework.TestCase;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class EntryPathIdentifierSerializationUtilityTest extends TestCase {
    public void test() {
        Stream.of(
                Map.entry("/entry/CYILICNQX", new EntryPathIdentifier("CYILICNQX"))
        ).forEach(
                e -> {
                    assertEquals(Optional.of(e.getValue()), EntryPathIdentifierSerializationUtility.getInstance().deserialize(e.getKey()));
                    assertEquals(e.getKey(), EntryPathIdentifierSerializationUtility.getInstance().serialize(e.getValue()));
                }
        );

        Stream.of(
                "entry",
                "entry/CYILICNQX",
                "/entry",
                "/entry/"
        ).forEach(
                e -> assertEquals(Optional.empty(), EntryPathIdentifierSerializationUtility.getInstance().deserialize(e))
        );
    }
}