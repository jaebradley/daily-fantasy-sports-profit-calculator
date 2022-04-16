package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.PlacesPaid;
import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.serialization.firstparty.strings.impl.AbstractNaturalNumberSerializationUtility;
import com.rvnu.serialization.firstparty.strings.impl.IntegerSerializationUtility;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

public class PlacesPaidSerializationUtility extends AbstractNaturalNumberSerializationUtility<PlacesPaid> {
    private static final PlacesPaidSerializationUtility INSTANCE = new PlacesPaidSerializationUtility(
            IntegerSerializationUtility.getInstance(),
            IntegerSerializationUtility.getInstance()
    );

    private PlacesPaidSerializationUtility(
            final Serializer<Long> integerSerializer,
            final Deserializer<Long> integerDeserializer
    ) {
        super(integerSerializer, integerDeserializer);
    }

    @Override
    protected PlacesPaid construct(long value) throws NaturalNumber.ValueMustNotBeNegative {
        return new PlacesPaid(value);
    }

    public static PlacesPaidSerializationUtility getInstance() {
        return INSTANCE;
    }
}
