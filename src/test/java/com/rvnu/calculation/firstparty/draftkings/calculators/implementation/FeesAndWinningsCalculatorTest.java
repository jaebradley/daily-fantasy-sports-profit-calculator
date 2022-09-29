package com.rvnu.calculation.firstparty.draftkings.calculators.implementation;

import com.rvnu.calculation.firstparty.draftkings.translators.implementation.SportTranslator;
import com.rvnu.data.thirdparty.draftkings.csv.records.Deserializer;
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
                "Sport","Game_Type","Entry_Key","Entry","Contest_Key","Contest_Date_EST","Place","Points","Winnings_Non_Ticket","Winnings_Ticket","Contest_Entries","Entry_Fee","Prize_Pool","Places_Paid"
                "NFL","Classic",3049390519,"NFL $5 Double Up (Sat)",121304070,"2021-12-25 16:30:00",321,119.38,"$0.00","$0.00",344,"$5.00","$1,500.00",150
                "NBA","Classic",2945036612,"NBA Single Entry $5 Double Up",117570665,"2021-11-05 19:00:00",1783,233,"$0.00","$0.00",3191,"$5.00","$15,000.00",1500
                "MLB","Classic",741872124,"APRIL SILVER STATUS FREE CONTEST [$25K]",40329143,"2017-05-03 19:05:00",23092,0,"$0.00","$0.00",33496,"$0.00","$25,000.00",415
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