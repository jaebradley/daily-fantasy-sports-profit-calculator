package com.rvnu.models.thirdparty.iso;

import org.javamoney.moneta.Money;

import java.util.Objects;

public class NonNegativeMonetaryValue {
    public static class ValueMustNotBeNegative extends Exception {
    }

    private final Money value;

    public NonNegativeMonetaryValue(final Money value) throws ValueMustNotBeNegative {
        if (value.isNegative()) {
            throw new ValueMustNotBeNegative();
        }
        this.value = value;
    }

    public Money getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonNegativeMonetaryValue that = (NonNegativeMonetaryValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "NonNegativeMonetaryValue{" +
                "value=" + value +
                '}';
    }
}
