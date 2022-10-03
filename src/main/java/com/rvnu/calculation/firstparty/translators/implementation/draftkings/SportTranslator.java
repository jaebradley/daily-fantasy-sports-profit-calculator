package com.rvnu.calculation.firstparty.translators.implementation.draftkings;

import com.rvnu.calculation.firstparty.translators.interfaces.Translator;
import com.rvnu.models.thirdparty.draftkings.contests.entries.Sport;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class SportTranslator implements Translator<Sport, com.rvnu.models.firstparty.Sport> {
    private static final EnumMap<Sport, com.rvnu.models.firstparty.Sport> sportsByDraftKingsSports = new EnumMap<Sport, com.rvnu.models.firstparty.Sport>(
            Map.of(Sport.Football, com.rvnu.models.firstparty.Sport.NFL,
                    Sport.Basketball, com.rvnu.models.firstparty.Sport.NBA,
                    Sport.Baseball, com.rvnu.models.firstparty.Sport.MLB)
    );

    static {
        if (Arrays.stream(Sport.values()).distinct().count() != sportsByDraftKingsSports.keySet().size() || Arrays.stream(com.rvnu.models.firstparty.Sport.values()).distinct().count() != sportsByDraftKingsSports.values().size()) {
            throw new RuntimeException("unexpected");
        }
    }

    private static final SportTranslator INSTANCE = new SportTranslator();

    private SportTranslator() {
    }

    @Override
    public Optional<com.rvnu.models.firstparty.Sport> translate(final Sport sport) {
        return Optional.ofNullable(sportsByDraftKingsSports.get(sport));
    }

    public static SportTranslator getInstance() {
        return INSTANCE;
    }
}
