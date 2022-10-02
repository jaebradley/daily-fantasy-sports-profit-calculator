package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.StartDate;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class StartDateSerializationUtility implements Deserializer<StartDate>, Serializer<StartDate> {
    private static final StartDateSerializationUtility INSTANCE = new StartDateSerializationUtility(DateTimeFormatter.ofPattern("yyy/MM/dd"));

    private final DateTimeFormatter formatter;

    private StartDateSerializationUtility(final DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public Optional<StartDate> deserialize(final String value) {
        final LocalDate date;
        try {
            date = LocalDate.parse(value, formatter);
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
        return Optional.of(new StartDate(date));
    }

    @Override
    public String serialize(final StartDate value) {
        return value.getValue().format(formatter);
    }

    public static StartDateSerializationUtility getInstance() {
        return INSTANCE;
    }
}
