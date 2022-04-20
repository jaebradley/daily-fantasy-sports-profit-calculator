package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.contests.entries.ContestKey;
import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.models.thirdparty.iso.PositiveInteger;
import com.rvnu.serialization.firstparty.strings.impl.AbstractPositiveIntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.impl.IntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

public class ContestKeySerializationUtility extends AbstractPositiveIntegerSerializationUtility<ContestKey> {
    private static final ContestKeySerializationUtility INSTANCE = new ContestKeySerializationUtility(
            IntegerSerializationUtility.getInstance(),
            IntegerSerializationUtility.getInstance()
    );

    private ContestKeySerializationUtility(
            final Serializer<Long> integerSerializer,
            final Deserializer<Long> integerDeserializer
    ) {
        super(integerSerializer, integerDeserializer);
    }

    @Override
    protected ContestKey construct(long value) throws NaturalNumber.ValueMustNotBeNegative, PositiveInteger.ValueMustBePositive {
        return new ContestKey(value);
    }

    public static ContestKeySerializationUtility getInstance() {
        return INSTANCE;
    }
}
