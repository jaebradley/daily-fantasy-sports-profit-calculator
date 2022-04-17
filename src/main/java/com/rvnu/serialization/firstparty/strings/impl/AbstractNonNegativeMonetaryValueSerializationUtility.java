package com.rvnu.serialization.firstparty.strings.impl;

import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;
import org.javamoney.moneta.Money;

import javax.money.format.MonetaryAmountFormat;
import java.util.Optional;

public abstract class AbstractNonNegativeMonetaryValueSerializationUtility<T extends NonNegativeMonetaryValue> implements Deserializer<T>, Serializer<T> {
    private final MonetaryAmountFormat format;

    protected AbstractNonNegativeMonetaryValueSerializationUtility(final MonetaryAmountFormat format) {
        this.format = format;
    }

    protected abstract T construct(Money value) throws NonNegativeMonetaryValue.ValueMustNotBeNegative;

    @Override
    public Optional<T> deserialize(final String value) {
        try {
            return Optional.of(construct(Money.parse(value, format)));
        } catch (NonNegativeMonetaryValue.ValueMustNotBeNegative e) {
            return Optional.empty();
        }
    }

    @Override
    public String serialize(final T value) {
        return format.format(value.getValue());
    }
}
