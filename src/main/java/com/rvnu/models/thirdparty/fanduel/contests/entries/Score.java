package com.rvnu.models.thirdparty.fanduel.contests.entries;

import java.math.BigDecimal;
import java.util.Objects;

public class Score {
    private final BigDecimal value;

    public Score(final BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return Objects.equals(value, score.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
