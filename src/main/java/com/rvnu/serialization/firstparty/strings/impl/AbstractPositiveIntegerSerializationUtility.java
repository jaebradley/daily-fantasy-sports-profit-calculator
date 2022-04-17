package com.rvnu.serialization.firstparty.strings.impl;

import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.models.thirdparty.iso.PositiveInteger;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.util.Optional;

public abstract class AbstractPositiveIntegerSerializationUtility<T extends PositiveInteger> implements Serializer<T>, Deserializer<T> {
    private final Serializer<Long> integerSerializer;
    private final Deserializer<Long> integerDeserializer;

    protected AbstractPositiveIntegerSerializationUtility(
            final Serializer<Long> integerSerializer,
            final Deserializer<Long> integerDeserializer
    ) {
        this.integerSerializer = integerSerializer;
        this.integerDeserializer = integerDeserializer;
    }

    protected abstract T construct(final long value) throws NaturalNumber.ValueMustNotBeNegative, PositiveInteger.ValueMustBePositive;

    @Override
    public Optional<T> deserialize(final String value) {
        return integerDeserializer.deserialize(value)
                .flatMap(
                        v -> {
                            try {
                                return Optional.of(construct(v));
                            } catch (NaturalNumber.ValueMustNotBeNegative | PositiveInteger.ValueMustBePositive e) {
                                return Optional.empty();
                            }
                        }
                );
    }
    @Override
    public String serialize(final T value) {
        return integerSerializer.serialize(value.getValue());
    }
}
