package com.rvnu.serialization.firstparty.strings.impl;

import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public abstract class AbstractLocalDateTimeSerializationUtility implements Deserializer<LocalDateTime>, Serializer<LocalDateTime> {
    private final DateTimeFormatter format;

    protected AbstractLocalDateTimeSerializationUtility(final DateTimeFormatter format) {
        this.format = format;
    }

    @Override
    public Optional<LocalDateTime> deserialize(final String value) {
        try {
            return Optional.of(LocalDateTime.parse(value, format));
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }

    @Override
    public String serialize(final LocalDateTime value) {
        return value.format(format);
    }
}
