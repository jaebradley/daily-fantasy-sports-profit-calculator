package com.rvnu.models.thirdparty.fanduel.contests.entries;

import java.util.Objects;

public class Name {
    public static class InvalidValue extends Exception {
    }

    private final String value;

    public Name(final String value) throws InvalidValue {
        if (value.isEmpty()) {
            throw new InvalidValue();
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
