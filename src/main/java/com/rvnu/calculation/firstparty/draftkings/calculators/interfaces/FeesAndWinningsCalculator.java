package com.rvnu.calculation.firstparty.draftkings.calculators.interfaces;

import com.rvnu.models.firstparty.Fees;
import com.rvnu.models.firstparty.Sport;
import com.rvnu.models.firstparty.Winnings;
import com.rvnu.models.thirdparty.draftkings.contests.entries.ContestEntryResult;

import java.util.Map;
import java.util.function.Supplier;

public interface FeesAndWinningsCalculator {

    // TODO: @jbradley replace Map with Context object for safe concurrent access
    void calculateFeesAndWinnings(Map<Sport, Map.Entry<Fees, Winnings>> profitBySport, Supplier<ContestEntryResult> contestEntryResultSupplier);
}
