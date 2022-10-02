package com.rvnu.data.firstparty.csv.record.columns;

import com.rvnu.models.thirdparty.iso.NaturalNumber;
import com.rvnu.models.thirdparty.iso.PositiveInteger;

import java.util.Optional;

public class PositiveIntegerDeserializer<Column extends Enum<Column>, Error extends Enum<Error>> extends AbstractValueDeserializer<PositiveInteger, Column, Error> {
    public PositiveIntegerDeserializer(
            Column column, Error columnDoesNotExistError, Error invalidValueError) {
        super(value -> {
            final PositiveInteger v;
            try {
                v = new PositiveInteger(Long.parseLong(value));
            } catch (NumberFormatException | NaturalNumber.ValueMustNotBeNegative | PositiveInteger.ValueMustBePositive e) {
                return Optional.empty();
            }

            return Optional.of(v);
        }, column, columnDoesNotExistError, invalidValueError);
    }
}
