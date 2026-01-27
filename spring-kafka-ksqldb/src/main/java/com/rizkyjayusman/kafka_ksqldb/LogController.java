package com.rizkyjayusman.kafka_ksqldb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @Autowired
    private LogProducerService producer;

    @GetMapping("/send")
    public String triggerLog(@RequestParam String method, @RequestParam String path, @RequestParam int status) {

        producer.sendRawLog(method, path, status);
        producer.sendJsonLog(method, path, status);

        return "Log sent to Kafka!";
    }
}