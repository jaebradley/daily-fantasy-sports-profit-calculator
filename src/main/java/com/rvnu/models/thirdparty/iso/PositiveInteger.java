package com.rvnu.models.thirdparty.iso;

import java.util.Objects;

public class PositiveInteger extends NaturalNumber {
    public static final PositiveInteger ONE;

    static {
        try {
            ONE = new PositiveInteger(1);
        } catch (ValueMustBePositive | ValueMustNotBeNegative e) {
            throw new IllegalStateException();
        }
    }

    public static class ValueMustBePositive extends Exception {
        public ValueMustBePositive() {
        }
    }

    private final long value;

    public PositiveInteger(final long value) throws ValueMustBePositive, ValueMustNotBeNegative {
        super(value);
        if (0 >= value) {
            throw new ValueMustBePositive();
        }
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveInteger that = (PositiveInteger) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
