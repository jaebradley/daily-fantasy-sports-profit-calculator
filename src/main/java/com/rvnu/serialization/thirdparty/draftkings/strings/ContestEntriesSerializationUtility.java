package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.ContestEntries;
import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.serialization.firstparty.strings.impl.AbstractNaturalNumberSerializationUtility;
import com.rvnu.serialization.firstparty.strings.impl.IntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

public class ContestEntriesSerializationUtility extends AbstractNaturalNumberSerializationUtility<ContestEntries> {
    private static final ContestEntriesSerializationUtility INSTANCE = new ContestEntriesSerializationUtility(
            IntegerSerializationUtility.getInstance(),
            IntegerSerializationUtility.getInstance()
    );

    private ContestEntriesSerializationUtility(
            final Serializer<Long> integerSerializer,
            final Deserializer<Long> integerDeserializer
    ) {
        super(integerSerializer, integerDeserializer);
    }

    @Override
    protected ContestEntries construct(final long value) throws NaturalNumber.ValueMustNotBeNegative {
        return new ContestEntries(value);
    }

    public static ContestEntriesSerializationUtility getInstance() {
        return INSTANCE;
    }
}
