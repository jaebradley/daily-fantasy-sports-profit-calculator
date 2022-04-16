package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.EntryPoints;
import com.rvnu.serialization.firstparty.strings.impl.DecimalSerializationUtility;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.math.BigDecimal;
import java.util.Optional;

public class EntryPointsSerializationUtility implements Deserializer<EntryPoints>, Serializer<EntryPoints> {
    private static final EntryPointsSerializationUtility INSTANCE = new EntryPointsSerializationUtility(
            DecimalSerializationUtility.getInstance(),
            DecimalSerializationUtility.getInstance()
    );

    private final Deserializer<BigDecimal> decimalDeserializer;
    private final Serializer<BigDecimal> decimalSerializer;

    private EntryPointsSerializationUtility(
            final Deserializer<BigDecimal> decimalDeserializer,
            final Serializer<BigDecimal> decimalSerializer
    ) {
        this.decimalDeserializer = decimalDeserializer;
        this.decimalSerializer = decimalSerializer;
    }

    @Override
    public Optional<EntryPoints> deserialize(final String value) {
        return decimalDeserializer
                .deserialize(value)
                .map(EntryPoints::new);
    }

    @Override
    public String serialize(final EntryPoints value) {
        return decimalSerializer.serialize(value.value());
    }

    public static EntryPointsSerializationUtility getInstance() {
        return INSTANCE;
    }
}
