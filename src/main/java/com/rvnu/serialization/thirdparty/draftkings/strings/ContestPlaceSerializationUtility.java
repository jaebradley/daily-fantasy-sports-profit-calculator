package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.contests.entries.ContestPlace;
import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.models.thirdparty.iso.PositiveInteger;
import com.rvnu.serialization.firstparty.strings.impl.AbstractPositiveIntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.impl.IntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

public final class ContestPlaceSerializationUtility extends AbstractPositiveIntegerSerializationUtility<ContestPlace> {
    private static final ContestPlaceSerializationUtility INSTANCE = new ContestPlaceSerializationUtility(
            IntegerSerializationUtility.getInstance(),
            IntegerSerializationUtility.getInstance()
    );

    private ContestPlaceSerializationUtility(
            final Serializer<Long> integerSerializer,
            final Deserializer<Long> integerDeserializer
    ) {
        super(integerSerializer, integerDeserializer);
    }

    @Override
    protected ContestPlace construct(final long value) throws NaturalNumber.ValueMustNotBeNegative, PositiveInteger.ValueMustBePositive {
        return new ContestPlace(value);
    }

    public static ContestPlaceSerializationUtility getInstance() {
        return INSTANCE;
    }
}
