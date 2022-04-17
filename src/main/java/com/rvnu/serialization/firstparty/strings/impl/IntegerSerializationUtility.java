package com.rvnu.serialization.firstparty.strings.impl;

import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.util.Optional;

public class IntegerSerializationUtility implements Serializer<Long>, Deserializer<Long> {
    private static IntegerSerializationUtility INSTANCE = new IntegerSerializationUtility();

    private IntegerSerializationUtility() {
    }

    @Override
    public Optional<Long> deserialize(final String value) {
        final long deserializedValue;
        try {
            deserializedValue = Long.parseLong(value);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
        return Optional.of(deserializedValue);
    }


    @Override
    public String serialize(final Long value) {
        return value.toString();
    }

    public static IntegerSerializationUtility getInstance() {
        return INSTANCE;
    }
}
