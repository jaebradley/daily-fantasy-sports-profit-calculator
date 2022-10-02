package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.EntryId;
import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.serialization.firstparty.strings.impl.IntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.util.Optional;

public class EntryIdSerializationUtility implements Deserializer<EntryId>, Serializer<EntryId> {
    private static final EntryIdSerializationUtility INSTANCE = new EntryIdSerializationUtility(
            "S",
            IntegerSerializationUtility.getInstance(),
            IntegerSerializationUtility.getInstance()
    );

    private final String prefix;
    private final Serializer<Long> serializer;
    private final Deserializer<Long> deserializer;

    private EntryIdSerializationUtility(
            final String prefix,
            final Serializer<Long> serializer,
            final Deserializer<Long> deserializer) {
        this.prefix = prefix;
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public static EntryIdSerializationUtility getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<EntryId> deserialize(final String value) {
        if (!value.startsWith(prefix)) {
            return Optional.empty();
        }

        return deserializer.deserialize(value.substring(prefix.length())).flatMap(v -> {
            try {
                return Optional.of(new EntryId(v));
            } catch (NaturalNumber.ValueMustNotBeNegative e) {
                return Optional.empty();
            }
        });
    }

    @Override
    public String serialize(final EntryId value) {
        return prefix + serializer.serialize(value.getValue());
    }
}
