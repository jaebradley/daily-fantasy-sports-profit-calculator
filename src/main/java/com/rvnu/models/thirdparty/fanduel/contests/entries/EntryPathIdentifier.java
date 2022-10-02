package com.rvnu.models.thirdparty.fanduel.contests.entries;

import java.util.Objects;

// TODO: @jbradley revisit this, because the value should probably be a URL-safe non-empty string
public class EntryPathIdentifier {
    private final String value;

    public EntryPathIdentifier(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryPathIdentifier that = (EntryPathIdentifier) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
