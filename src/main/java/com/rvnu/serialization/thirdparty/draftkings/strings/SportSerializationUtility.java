package com.rvnu.serialization.thirdparty.draftkings.strings;

import com.rvnu.models.thirdparty.draftkings.contests.entries.Sport;
import com.rvnu.serialization.firstparty.strings.impl.AbstractEnumSerializationUtility;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SportSerializationUtility extends AbstractEnumSerializationUtility<Sport> {
    private static final SportSerializationUtility INSTANCE = new SportSerializationUtility(
            new EnumMap<Sport, String>(
                    Stream.of(
                            Map.entry(Sport.Football, "NFL"),
                            Map.entry(Sport.Baseball, "MLB"),
                            Map.entry(Sport.Golf, "GOLF"),
                            Map.entry(Sport.Basketball, "NBA"),
                            Map.entry(Sport.Hockey, "NHL"),
                            Map.entry(Sport.College_Football, "CFB"),
                            Map.entry(Sport.Nascar, "NAS"),
                            Map.entry(Sport.Mixed_Martial_Arts, "MMA"),
                            Map.entry(Sport.Soccer, "SOC"),
                            Map.entry(Sport.Formula_One, "F1"),
                            Map.entry(Sport.League_of_Legends, "LOL"),
                            Map.entry(Sport.Tennis, "TEN"),
                            Map.entry(Sport.United_States_Football_League, "USFL"),
                            Map.entry(Sport.College_Basketball, "CBB"),
                            Map.entry(Sport.Counter_Strike_Global_Offensive, "CS:GO"),
                            Map.entry(Sport.Canadian_Football, "CFL"),
                            Map.entry(Sport.Call_Of_Duty, "COD"),
                            Map.entry(Sport.EuroLeague_Basketball, "EL"),
                            Map.entry(Sport.Valorant, "VAL"),
                            Map.entry(Sport.XFL, "XFL"),
                            Map.entry(Sport.Defense_of_the_Ancient_2, "DOTA2"),
                            Map.entry(Sport.Rocket_League, "RL"),
                            Map.entry(Sport.Australian_Football_League, "AUSFL"),
                            Map.entry(Sport.iRacing, "IRACE"),
                            Map.entry(Sport.Miscellaneous, "MISC")
                    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            )
    );

    private SportSerializationUtility(final EnumMap<Sport, String> serializationsByValue) {
        super(serializationsByValue, Sport.class);
    }

    public static SportSerializationUtility getInstance() {
        return INSTANCE;
    }
}
