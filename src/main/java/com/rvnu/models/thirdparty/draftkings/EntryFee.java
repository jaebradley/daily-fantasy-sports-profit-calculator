package com.rvnu.models.thirdparty.draftkings;

import org.javamoney.moneta.Money;

import java.util.Objects;

public class EntryFee {
    private final Money value;

    public EntryFee(final Money value) {
        this.value = value;
    }

    public Money getValue() {
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
