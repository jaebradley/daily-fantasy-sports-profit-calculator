package com.rvnu.calculation.firstparty.draftkings.translators.implementation;

import com.rvnu.calculation.firstparty.draftkings.translators.interfaces.Translator;
import com.rvnu.models.firstparty.Winnings;
import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;

import java.util.Optional;

public class WinningsTranslator implements Translator<com.rvnu.models.thirdparty.draftkings.contests.entries.Winnings, Winnings> {
    @Override
    public Optional<Winnings> translate(final com.rvnu.models.thirdparty.draftkings.contests.entries.Winnings winnings) {
        final Winnings value;
        try {
            value = new Winnings(
                    winnings.nonTicket().getValue().add(winnings.ticket().getValue())
            );
        } catch (NonNegativeMonetaryValue.ValueMustNotBeNegative valueMustNotBeNegative) {
            return Optional.empty();
        }
        return Optional.of(value);
    }
}
