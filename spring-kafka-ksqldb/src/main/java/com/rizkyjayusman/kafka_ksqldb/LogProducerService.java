package com.rizkyjayusman.kafka_ksqldb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendRawLog(String method, String path, int status) {
        String rawLog = String.format("%s | %s | %d", method, path, status);
        kafkaTemplate.send("log-raw", rawLog);
    }

    public void sendJsonLog(String method, String path, int status) {
        String jsonLog = String.format(
                "{\"method\":\"%s\", \"path\":\"%s\", \"status\":%d}",
                method, path, status
        );
        kafkaTemplate.send("log-json", jsonLog);
    }
}