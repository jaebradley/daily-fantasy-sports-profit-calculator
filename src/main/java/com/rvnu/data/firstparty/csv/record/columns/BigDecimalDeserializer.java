package com.rvnu.data.firstparty.csv.record.columns;

import java.math.BigDecimal;
import java.util.Optional;

public class BigDecimalDeserializer<Column extends Enum<Column>, Error extends Enum<Error>> extends AbstractValueDeserializer<BigDecimal, Column, Error> {
    public BigDecimalDeserializer(Column column, Error columnDoesNotExistError, Error invalidValueError) {
        // TODO @jbradley move this to a serializer
        super(value -> {
            final BigDecimal v;
            try {
                v = new BigDecimal(value);
            } catch (NumberFormatException e) {
                return Optional.empty();
            }

            return Optional.of(v);
        }, column, columnDoesNotExistError, invalidValueError);
    }
}
