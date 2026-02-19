package com.rizkyjayusman.rate_limiting.controllers;

import com.rizkyjayusman.rate_limiting.configs.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RateLimit(
            key = "hello-world",
            capacity = 5,
            refillTokens = 5,
            refillSeconds = 60
    )
    @GetMapping("/hello-world")
    public String helloWorld(@RequestBody Request request) {
        return "hello world, " + request.accountNumber();
    }

    @RateLimit(
            key = "hello-you",
            capacity = 20,
            refillTokens = 20,
            refillSeconds = 60
    )
    @GetMapping("/hello-you")
    public String helloYou() {
        return "hello, you!";
    }

    public record Request(String accountNumber) {
    }
}