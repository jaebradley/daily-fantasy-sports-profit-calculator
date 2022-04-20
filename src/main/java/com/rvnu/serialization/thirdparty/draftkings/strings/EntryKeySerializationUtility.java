package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.contests.entries.EntryKey;
import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.models.thirdparty.iso.PositiveInteger;
import com.rvnu.serialization.firstparty.strings.impl.AbstractPositiveIntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.impl.IntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

public class EntryKeySerializationUtility extends AbstractPositiveIntegerSerializationUtility<EntryKey> {
    private static final EntryKeySerializationUtility INSTANCE = new EntryKeySerializationUtility(
            IntegerSerializationUtility.getInstance(),
            IntegerSerializationUtility.getInstance()
    );

    private EntryKeySerializationUtility(
            final Serializer<Long> integerSerializer,
            final Deserializer<Long> integerDeserializer
    ) {
        super(integerSerializer, integerDeserializer);
    }

    @Override
    protected EntryKey construct(final long value) throws NaturalNumber.ValueMustNotBeNegative, PositiveInteger.ValueMustBePositive {
        return new EntryKey(value);
    }

    public static EntryKeySerializationUtility getInstance() {
        return INSTANCE;
    }
}
