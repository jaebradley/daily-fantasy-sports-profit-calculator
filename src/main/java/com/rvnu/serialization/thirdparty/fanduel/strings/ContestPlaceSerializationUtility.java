package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.ContestPlace;
import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.models.thirdparty.iso.PositiveInteger;
import com.rvnu.serialization.firstparty.strings.impl.AbstractPositiveIntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.impl.IntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

public class ContestPlaceSerializationUtility extends AbstractPositiveIntegerSerializationUtility<ContestPlace> {
    private static final ContestPlaceSerializationUtility INSTANCE = new ContestPlaceSerializationUtility(
            IntegerSerializationUtility.getInstance(),
            IntegerSerializationUtility.getInstance()
    );

    private ContestPlaceSerializationUtility(final Serializer<Long> integerSerializer, Deserializer<Long> integerDeserializer) {
        super(integerSerializer, integerDeserializer);
    }

    @Override
    protected final ContestPlace construct(final long value) throws NaturalNumber.ValueMustNotBeNegative, PositiveInteger.ValueMustBePositive {
        return new ContestPlace(value);
    }

    public static ContestPlaceSerializationUtility getInstance() {
        return INSTANCE;
    }
}
