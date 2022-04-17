package com.rvnu.serialization.firstparty.strings.impl;

import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.math.BigDecimal;
import java.util.Optional;

public final class DecimalSerializationUtility implements Serializer<BigDecimal>, Deserializer<BigDecimal> {
    private static final DecimalSerializationUtility INSTANCE = new DecimalSerializationUtility();

    private DecimalSerializationUtility() {
    }

    @Override
    public Optional<BigDecimal> deserialize(final String value) {
        try {
            return Optional.of(new BigDecimal(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Override
    public String serialize(final BigDecimal value) {
        return value.toPlainString();
    }

    public static DecimalSerializationUtility getInstance() {
        return INSTANCE;
    }
}
