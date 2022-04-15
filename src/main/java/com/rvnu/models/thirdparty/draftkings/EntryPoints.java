package com.rvnu.models.thirdparty.draftkings;

import java.math.BigDecimal;
import java.util.Objects;

public class EntryPoints {
    private final BigDecimal value;

    public EntryPoints(final BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryPoints that = (EntryPoints) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "EntryPoints{" +
                "value=" + value +
                '}';
    }
}
