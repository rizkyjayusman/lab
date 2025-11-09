package com.hackerrank.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class SampleController {

    @GetMapping("/defaultHello")
    public Response defaultHello(@RequestParam(value = "message", required = false) String message) {
        StringBuilder builder = new StringBuilder("Hello").append(" ");
        if (Objects.isNull(message) || message.equals("")) {
            message = "World!";
        }
        builder.append(message);
        return new Response(builder.toString());
    }

    @PostMapping("/customHello")
    public Response customHello(@RequestParam("message") String message) {
        return new Response("Custom " + message);
    }

    public static class Response {

        private final String echo;

        public Response(String echo) {
            this.echo = echo;
        }

        public String getEcho() {
            return echo;
        }
    }

}
