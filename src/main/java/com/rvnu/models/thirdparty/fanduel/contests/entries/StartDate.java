package com.rvnu.models.thirdparty.fanduel.contests.entries;

import java.time.LocalDate;
import java.util.Objects;

public class StartDate {
    private final LocalDate value;

    public StartDate(final LocalDate value) {
        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartDate startDate = (StartDate) o;
        return Objects.equals(value, startDate.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
