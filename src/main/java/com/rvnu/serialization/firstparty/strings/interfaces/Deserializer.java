package com.rvnu.serialization.firstparty.strings.interfaces;

import io.vavr.control.Either;

import java.util.Optional;

public interface Deserializer<T> {
    Optional<T> deserialize(String value);
}
