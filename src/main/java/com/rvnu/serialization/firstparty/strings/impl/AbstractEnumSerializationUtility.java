package com.rvnu.serialization.firstparty.strings.impl;

import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractEnumSerializationUtility<T extends Enum<T>> implements Deserializer<T>, Serializer<T> {
    private final EnumMap<T, String> serializationsByValue;
    private final Map<String, T> valuesBySerialization;

    public AbstractEnumSerializationUtility(final EnumMap<T, String> serializationsByValue) {
        this.serializationsByValue = serializationsByValue;
        this.valuesBySerialization = serializationsByValue
                .entrySet()
                .stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getValue,
                                Map.Entry::getKey
                        )
                );
    }

    @Override
    public Optional<T> deserialize(final String value) {
        return Optional.ofNullable(valuesBySerialization.get(value));
    }

    @Override
    public String serialize(T value) {
        return serializationsByValue.get(value);
    }
}
