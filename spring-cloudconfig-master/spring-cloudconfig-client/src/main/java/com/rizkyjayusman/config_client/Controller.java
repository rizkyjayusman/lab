package com.rizkyjayusman.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class Controller {

    @Value("${hello.world}")
    private String hello;

    @GetMapping("/get")
    public String get() {
        return hello;
    }
}
