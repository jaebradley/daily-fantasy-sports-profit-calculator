package com.rvnu.data.firstparty.csv.record.columns;

import com.rvnu.models.thirdparty.iso.NonNegativeMonetaryValue;
import org.javamoney.moneta.Money;

import javax.money.UnknownCurrencyException;
import javax.money.format.MonetaryParseException;
import java.util.Optional;

public class NonNegativeMonetaryValueDeserializer<Column extends Enum<Column>, Error extends Enum<Error>> extends AbstractValueDeserializer<NonNegativeMonetaryValue, Column, Error> {
    public NonNegativeMonetaryValueDeserializer(Column column, Error columnDoesNotExistError, Error invalidValueError) {
        super(value -> {
            final NonNegativeMonetaryValue v;
            try {
                v = new NonNegativeMonetaryValue(Money.parse(value));
            } catch (NonNegativeMonetaryValue.ValueMustNotBeNegative | NumberFormatException | UnknownCurrencyException | MonetaryParseException e) {
                return Optional.empty();
            }
            return Optional.of(v);
        }, column, columnDoesNotExistError, invalidValueError);
    }
}
