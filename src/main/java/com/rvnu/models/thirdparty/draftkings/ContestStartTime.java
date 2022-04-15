package com.rvnu.models.thirdparty.draftkings;

import java.time.Instant;
import java.util.Objects;

public class ContestStartTime {
    private final Instant value;

    public ContestStartTime(Instant value) {
        this.value = value;
    }

    public Instant getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContestStartTime that = (ContestStartTime) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
