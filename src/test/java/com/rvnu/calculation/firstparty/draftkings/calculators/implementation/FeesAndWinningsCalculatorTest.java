package com.rvnu.calculation.firstparty.draftkings.calculators.implementation;

import com.rvnu.calculation.firstparty.draftkings.translators.implementation.SportTranslator;
import com.rvnu.calculation.firstparty.draftkings.translators.implementation.WinningsTranslator;
import com.rvnu.data.thirdparty.draftkings.csv.records.Deserializer;
import com.rvnu.models.firstparty.Fees;
import com.rvnu.models.firstparty.Sport;
import com.rvnu.models.firstparty.Winnings;
import junit.framework.TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class FeesAndWinningsCalculatorTest extends TestCase {

    public void test() {
        final FeesAndWinningsCalculator feesAndWinningsCalculator = new FeesAndWinningsCalculator(
                new SportTranslator(),
                new WinningsTranslator()
        );

        final Map<Sport, Map.Entry<Fees, Winnings>> profitsBySport = new HashMap<>();

        try {
            Deserializer.getInstance()
                    .deserialize(
                            new FileInputStream("some test file"),
                            contestEntryResult -> feesAndWinningsCalculator.calculateFeesAndWinnings(profitsBySport, () -> contestEntryResult)
                    );
        } catch (com.rvnu.data.firstparty.csv.records.interfaces.Deserializer.UnableToDeserializeRecords | FileNotFoundException e) {
            fail();
        }

        assertFalse(profitsBySport.isEmpty());
    }
}