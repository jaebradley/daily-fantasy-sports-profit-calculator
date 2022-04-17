package com.rvnu.serialization.firstparty.strings.interfaces;

public interface Serializer<T> {
    String serialize(T value);
}
