package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.EntryPathIdentifier;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.util.Optional;

public class EntryPathIdentifierSerializationUtility implements Deserializer<EntryPathIdentifier>, Serializer<EntryPathIdentifier> {
    private static final EntryPathIdentifierSerializationUtility INSTANCE = new EntryPathIdentifierSerializationUtility();

    private EntryPathIdentifierSerializationUtility() {
    }

    @Override
    public Optional<EntryPathIdentifier> deserialize(final String value) {
        if (!value.startsWith("/entry/") || value.equals("/entry/")) {
            return Optional.empty();
        }

        final String remainingIdentifier = value.substring("/entry/".length());
        for (final char c : remainingIdentifier.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                return Optional.empty();
            }
        }

        return Optional.of(new EntryPathIdentifier(remainingIdentifier));
    }

    @Override
    public String serialize(final EntryPathIdentifier value) {
        return "/entry/" + value.getValue();
    }

    public static EntryPathIdentifierSerializationUtility getInstance() {
        return INSTANCE;
    }
}
