package com.rvnu.calculation.firstparty.fanduel.calculators.implementation;

import com.rvnu.calculation.firstparty.translators.implementation.fanduel.SportTranslator;
import com.rvnu.data.thirdparty.fanduel.csv.records.Deserializer;
import com.rvnu.models.firstparty.Fees;
import com.rvnu.models.firstparty.Sport;
import com.rvnu.models.firstparty.Winnings;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FeesAndWinningsCalculatorTest extends TestCase {

    public void test() {
        final String firstTwoRows = """
                Entry Id,Sport,Date,Title,SalaryCap,Score,Opp Score,Position,Entries,Opponent,Entry ($),Winnings ($),Link
                S1995847859,nba,2020/02/21,$200K Fri NBA Shot Machine ($50K to 1st),$60k,320.60,,8161,30642,Tournament,7.77,0,/entry/CMEEISAUO,
                S1203809799,nba,2017/04/20,NBA $2 Double Up (Beginners Only),$60k,270.80,,3,22,Tournament,2,4.00,/entry/AIHTOFWHD,
                S1203809678,nba,2017/04/20,NBA $1 50/50 Contest (Beginners Only) (Main),$60k,270.80,,2,20,Tournament,1,1.80,/entry/DBYUWFHEN,
                S1203809087,nba,2017/04/20,NBA $1 50/50 Contest (Beginners Only) (Main),$60k,270.80,,3,20,Tournament,1,1.80,/entry/DVFIKNNDP,
                """;

        final FeesAndWinningsCalculator feesAndWinningsCalculator = new FeesAndWinningsCalculator(SportTranslator.getInstance());

        final Map<Sport, Map.Entry<Fees, Winnings>> profitsBySport = new HashMap<>();

        try {
            Deserializer.getInstance()
                    .deserialize(
                            new ByteArrayInputStream(firstTwoRows.getBytes(StandardCharsets.UTF_8)),
                            contestEntryResult -> feesAndWinningsCalculator.calculateFeesAndWinnings(profitsBySport, () -> contestEntryResult)
                    );
        } catch (com.rvnu.data.firstparty.csv.records.interfaces.Deserializer.UnableToDeserializeRecords e) {
            fail();
        }

        assertFalse(profitsBySport.isEmpty());
    }
}