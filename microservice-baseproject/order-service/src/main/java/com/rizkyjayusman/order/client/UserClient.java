package com.rizkyjayusman.order.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    private final RestTemplate rest = new RestTemplate();

    @Value("${internal-services.user-service.base-url}")
    private String baseUrl;

    public boolean isUserValid(Long userId) {
        String url = baseUrl + "/api/v1/users/" + userId + "/validate";
        Boolean result = rest.getForObject(url, Boolean.class);
        return Boolean.TRUE.equals(result);
    }
}
