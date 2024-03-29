package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.contests.entries.ContestStartTime;
import com.rvnu.serialization.firstparty.strings.impl.AbstractLocalDateTimeSerializationUtility;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ContestStartTimeSerializationUtility implements Serializer<ContestStartTime>, Deserializer<ContestStartTime> {
    private static final ContestStartTimeSerializationUtility INSTANCE = new ContestStartTimeSerializationUtility(
            ZonedDateTime::toString,
            new AbstractLocalDateTimeSerializationUtility(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            ) {
            },
            ZoneId.of("America/New_York")
    );

    private final Serializer<ZonedDateTime> startTimeSerializer;
    private final Deserializer<LocalDateTime> localDateTimeDeserializer;
    private final ZoneId timeZone;

    private ContestStartTimeSerializationUtility(
            final Serializer<ZonedDateTime> startTimeSerializer,
            final Deserializer<LocalDateTime> localDateTimeDeserializer,
            final ZoneId timeZone
    ) {
        this.startTimeSerializer = startTimeSerializer;
        this.localDateTimeDeserializer = localDateTimeDeserializer;
        this.timeZone = timeZone;
    }

    @Override
    public Optional<ContestStartTime> deserialize(final String value) {
        return localDateTimeDeserializer
                .deserialize(value)
                .map(localDateTime -> localDateTime.atZone(timeZone))
                .map(ContestStartTime::new);
    }

    @Override
    public String serialize(final ContestStartTime value) {
        return startTimeSerializer.serialize(value.value());
    }

    public static ContestStartTimeSerializationUtility getInstance() {
        return INSTANCE;
    }
}
