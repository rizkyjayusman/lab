package com.rizkyjayusman;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String input =
                "Java is powerful. Java is versatile. Streams in Java make processing data easier.\n" +
                "The Java community loves streams, and streams make Java programs elegant.\n" +
                "Functional programming in Java, with streams and lambdas, is a game changer.\n" +
                "Big data processing, parallel streams, and efficient Java code go hand in hand.\n" +
                "Streams, streams, and more streams! Java developers enjoy functional style programming.\n";

        TextNormalizer normalizer = new TextNormalizer();
        Tokenizer tokenizer = new Tokenizer();

        Map<String, Long> result = input.lines()
                .flatMap(e -> normalizer.normalize(e).describeConstable().stream())
                .flatMap(e -> tokenizer.convert(e).stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Set<Map.Entry<String, Long>> sorted = result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new)).entrySet().stream().limit(3).collect(Collectors.toSet());

//        List<String> tokens = tokenizer.convert();
        ;
    }
}