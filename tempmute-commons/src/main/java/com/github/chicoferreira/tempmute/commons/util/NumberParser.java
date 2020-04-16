package com.github.chicoferreira.tempmute.commons.util;

import java.util.OptionalLong;

public class NumberParser {

    public static OptionalLong parseLong(String value) {
        try {
            return OptionalLong.of(Long.parseLong(value));
        } catch (NumberFormatException e) {
            return OptionalLong.empty();
        }
    }

}
