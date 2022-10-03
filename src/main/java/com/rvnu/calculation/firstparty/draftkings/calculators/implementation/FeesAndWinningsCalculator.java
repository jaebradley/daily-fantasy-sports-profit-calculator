package com.rvnu.calculation.firstparty.draftkings.calculators.implementation;

import com.rvnu.calculation.firstparty.translators.interfaces.Translator;
import com.rvnu.models.firstparty.Fees;
import com.rvnu.models.firstparty.Sport;
import com.rvnu.models.firstparty.Winnings;
import com.rvnu.models.thirdparty.draftkings.contests.entries.ContestEntryResult;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;

import java.util.Map;
import java.util.function.Supplier;

public class FeesAndWinningsCalculator implements com.rvnu.calculation.firstparty.calculators.interfaces.FeesAndWinningsCalculator<ContestEntryResult> {
    private final Translator<com.rvnu.models.thirdparty.draftkings.contests.entries.Sport, Sport> sportTranslator;

    public FeesAndWinningsCalculator(final Translator<com.rvnu.models.thirdparty.draftkings.contests.entries.Sport, Sport> sportTranslator) {
        this.sportTranslator = sportTranslator;
    }

    @Override
    public void calculateFeesAndWinnings(Map<Sport, Map.Entry<Fees, Winnings>> profitBySport, Supplier<ContestEntryResult> contestEntryResultSupplier) {
        final ContestEntryResult result = contestEntryResultSupplier.get();
        try {
            profitBySport.merge(
                    sportTranslator.translate(result.sport()).orElseThrow(),
                    Map.entry(
                            new Fees(result.entryFee().getValue()),
                            // TODO: @jbradley move this logic to a utility potentially
                            new Winnings(result.winnings().nonTicket().getValue().add(result.winnings().ticket().getValue()))
                    ),
                    (entry1, entry2) -> {
                        try {
                            return Map.entry(
                                    new Fees(entry1.getKey().getValue().add(entry2.getKey().getValue())),
                                    new Winnings(entry1.getValue().getValue().add(entry2.getValue().getValue()))
                            );
                        } catch (NonNegativeMonetaryValue.ValueMustNotBeNegative e) {
                            throw new RuntimeException("unexpected", e);
                        }
                    }
            );
        } catch (NonNegativeMonetaryValue.ValueMustNotBeNegative e) {
            throw new RuntimeException("unexpected", e);
        }
    }
}
