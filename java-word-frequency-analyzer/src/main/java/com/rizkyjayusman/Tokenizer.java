package com.rizkyjayusman;

import java.util.List;

public class Tokenizer {
    public Tokenizer() {}

    public List<String> convert(String input) {
        return input.lines().flatMap(line -> java.util.Arrays.stream(line.split("\\s+"))).toList();
    }
}
