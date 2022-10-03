package com.rvnu.calculation.firstparty.calculators.interfaces;

import com.rvnu.models.firstparty.Fees;
import com.rvnu.models.firstparty.Sport;
import com.rvnu.models.firstparty.Winnings;

import java.util.Map;
import java.util.function.Supplier;

public interface FeesAndWinningsCalculator<EntryResult> {

    // TODO: @jbradley replace Map with Context object for safe concurrent access
    void calculateFeesAndWinnings(Map<Sport, Map.Entry<Fees, Winnings>> profitBySport, Supplier<EntryResult> contestEntryResultSupplier);
}
