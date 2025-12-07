package com.rizkyjayusman.order.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    private final RestTemplate rest = new RestTemplate();

    public boolean isUserValid(Long userId) {
        String url = "http://user-service:8081/users/" + userId + "/validate";
        Boolean result = rest.getForObject(url, Boolean.class);
        return Boolean.TRUE.equals(result);
    }
}
