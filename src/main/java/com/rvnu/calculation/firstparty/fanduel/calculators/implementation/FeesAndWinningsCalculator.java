package com.rvnu.calculation.firstparty.fanduel.calculators.implementation;

import com.rvnu.calculation.firstparty.translators.interfaces.Translator;
import com.rvnu.models.firstparty.Fees;
import com.rvnu.models.firstparty.Sport;
import com.rvnu.models.firstparty.Winnings;
import com.rvnu.models.thirdparty.fanduel.contests.entries.Entry;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import org.javamoney.moneta.Money;

import java.util.Map;
import java.util.function.Supplier;

public class FeesAndWinningsCalculator implements com.rvnu.calculation.firstparty.calculators.interfaces.FeesAndWinningsCalculator<Entry> {
    private final Translator<com.rvnu.models.thirdparty.fanduel.contests.entries.Sport, Sport> sportTranslator;

    public FeesAndWinningsCalculator(final Translator<com.rvnu.models.thirdparty.fanduel.contests.entries.Sport, Sport> sportTranslator) {
        this.sportTranslator = sportTranslator;
    }

    @Override
    public void calculateFeesAndWinnings(final Map<Sport, Map.Entry<Fees, Winnings>> profitBySport, final Supplier<Entry> entrySupplier) {
        final Entry entry = entrySupplier.get();
        try {
            profitBySport.merge(
                    sportTranslator.translate(entry.sport()).orElseThrow(),
                    // TODO: @jbradley handle this hard-coded value
                    Map.entry(new Fees(Money.of(entry.entryFee(), "USD")), new Winnings(Money.of(entry.winnings(), "USD"))),
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
