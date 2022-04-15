package com.rvnu.models.thirdparty.draftkings;

import java.math.BigDecimal;
import java.util.Objects;

public class EntryFee {
    private final BigDecimal value;

    public EntryFee(final BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryFee entryFee = (EntryFee) o;
        return Objects.equals(value, entryFee.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "EntryFee{" +
                "value=" + value +
                '}';
    }
}
