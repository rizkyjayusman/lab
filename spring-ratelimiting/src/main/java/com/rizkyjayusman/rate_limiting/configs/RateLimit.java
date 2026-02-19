package com.rizkyjayusman.rate_limiting.configs;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface RateLimit {
    String key();
    int capacity();
    int refillTokens();
    int refillSeconds();
}
