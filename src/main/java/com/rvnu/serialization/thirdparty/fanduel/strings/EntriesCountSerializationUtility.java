package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.EntriesCount;
import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.models.thirdparty.iso.PositiveInteger;
import com.rvnu.serialization.firstparty.strings.impl.AbstractPositiveIntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.impl.IntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

public class EntriesCountSerializationUtility extends AbstractPositiveIntegerSerializationUtility<EntriesCount> {
    private static final EntriesCountSerializationUtility INSTANCE = new EntriesCountSerializationUtility(
            IntegerSerializationUtility.getInstance(),
            IntegerSerializationUtility.getInstance()
    );

    private EntriesCountSerializationUtility(final Serializer<Long> integerSerializer, Deserializer<Long> integerDeserializer) {
        super(integerSerializer, integerDeserializer);
    }

    @Override
    protected final EntriesCount construct(final long value) throws NaturalNumber.ValueMustNotBeNegative, PositiveInteger.ValueMustBePositive {
        return new EntriesCount(value);
    }

    public static EntriesCountSerializationUtility getInstance() {
        return INSTANCE;
    }
}
