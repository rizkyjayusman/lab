package com.rizkyjayusman;

public class TextNormalizer {
    public TextNormalizer() {}

    public String normalize(String input) {
        return input.toLowerCase()
                .replace(".","")
                .replace(",","")
                .replace("!","");
    }
}
