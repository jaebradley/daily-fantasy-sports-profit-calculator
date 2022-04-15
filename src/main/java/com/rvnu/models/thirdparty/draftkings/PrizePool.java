package com.rvnu.models.thirdparty.draftkings;

import java.math.BigDecimal;
import java.util.Objects;

public class PrizePool {
    private final BigDecimal value;

    public PrizePool(final BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrizePool prizePool = (PrizePool) o;
        return Objects.equals(value, prizePool.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PrizePool{" +
                "value=" + value +
                '}';
    }
}
