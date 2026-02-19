package com.rizkyjayusman.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConfigPrinter implements CommandLineRunner {

    @Value("${hello.world}")
    private String message;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("print from console : " + message);
    }
}
