package com.rvnu.calculation.firstparty.translators.implementation.fanduel;

import com.rvnu.calculation.firstparty.translators.interfaces.Translator;
import com.rvnu.models.thirdparty.fanduel.contests.entries.Sport;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class SportTranslator implements Translator<Sport, com.rvnu.models.firstparty.Sport> {
    private static final SportTranslator INSTANCE = new SportTranslator(
            new EnumMap<Sport, com.rvnu.models.firstparty.Sport>(
                    Map.of(
                            Sport.nba, com.rvnu.models.firstparty.Sport.NBA
                    )
            )
    );

    private final EnumMap<Sport, com.rvnu.models.firstparty.Sport> sportMapping;

    private SportTranslator(final EnumMap<Sport, com.rvnu.models.firstparty.Sport> sportMapping) {
        this.sportMapping = sportMapping;
    }

    @Override
    public Optional<com.rvnu.models.firstparty.Sport> translate(final Sport sport) {
        return Optional.ofNullable(sportMapping.get(sport));
    }

    public static SportTranslator getInstance() {
        return INSTANCE;
    }
}
