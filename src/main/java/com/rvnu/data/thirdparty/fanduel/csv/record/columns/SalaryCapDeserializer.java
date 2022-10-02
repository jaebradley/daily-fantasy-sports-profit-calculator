package com.rvnu.data.thirdparty.fanduel.csv.record.columns;

import com.rvnu.data.firstparty.csv.record.columns.AbstractValueDeserializer;
import com.rvnu.data.thirdparty.fanduel.csv.record.impl.Deserializer;
import com.rvnu.models.thirdparty.fanduel.contests.entries.SalaryCap;
import com.rvnu.serialization.thirdparty.fanduel.strings.SalaryCapSerializationUtility;

public class SalaryCapDeserializer extends AbstractValueDeserializer<SalaryCap, Deserializer.Column, Deserializer.Error> {
    private static final SalaryCapDeserializer INSTANCE = new SalaryCapDeserializer(
            SalaryCapSerializationUtility.getInstance(),
            Deserializer.Column.SALARY_CAP,
            Deserializer.Error.COLUMN_DOES_NOT_EXIST,
            Deserializer.Error.INVALID_SALARY_CAP
    );

    private SalaryCapDeserializer(com.rvnu.serialization.firstparty.strings.interfaces.Deserializer<SalaryCap> salaryCapDeserializer, Deserializer.Column column, Deserializer.Error columnDoesNotExistError, Deserializer.Error invalidValueError) {
        super(salaryCapDeserializer, column, columnDoesNotExistError, invalidValueError);
    }

    public static SalaryCapDeserializer getInstance() {
        return INSTANCE;
    }
}
