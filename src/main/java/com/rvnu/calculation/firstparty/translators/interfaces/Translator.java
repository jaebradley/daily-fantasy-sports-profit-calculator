package com.rvnu.calculation.firstparty.translators.interfaces;

import java.util.Optional;

public interface Translator<From, To> {
    Optional<To> translate(From from);
}
