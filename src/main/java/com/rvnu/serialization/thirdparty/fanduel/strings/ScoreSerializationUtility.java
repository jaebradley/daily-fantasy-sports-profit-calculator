package com.rvnu.serialization.thirdparty.fanduel.strings;

import com.rvnu.models.thirdparty.fanduel.contests.entries.Score;
import com.rvnu.serialization.firstparty.strings.interfaces.Deserializer;
import com.rvnu.serialization.firstparty.strings.interfaces.Serializer;

import java.math.BigDecimal;
import java.util.Optional;

public class ScoreSerializationUtility implements Deserializer<Score>, Serializer<Score> {
    private static final ScoreSerializationUtility INSTANCE = new ScoreSerializationUtility();

    private ScoreSerializationUtility() {
    }

    @Override
    public Optional<Score> deserialize(final String value) {
        final BigDecimal score;
        try {
            score = new BigDecimal(value);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }

        return Optional.of(new Score(score));
    }

    @Override
    public String serialize(final Score value) {
        return value.getValue().toPlainString();
    }

    public static ScoreSerializationUtility getInstance() {
        return INSTANCE;
    }
}
