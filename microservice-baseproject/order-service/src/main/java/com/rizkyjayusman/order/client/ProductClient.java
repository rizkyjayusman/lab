package com.rizkyjayusman.order.client;

import com.rizkyjayusman.order.dto.CreateOrderRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class ProductClient {

    private final RestTemplate rest = new RestTemplate();

    public boolean checkStock(List<CreateOrderRequest.Item> items) {
        String url = "http://product-service:8082/products/stock/check";
        Map<String, Object> body = Map.of("items", items);
        Map<String, Object> result = rest.postForObject(url, body, Map.class);
        return Boolean.TRUE.equals(result.get("success"));
    }

    public boolean decreaseStock(List<CreateOrderRequest.Item> items) {
        String url = "http://product-service:8082/products/stock/decrease";
        Map<String, Object> body = Map.of("items", items);
        Map<String, Object> result = rest.postForObject(url, body, Map.class);
        return Boolean.TRUE.equals(result.get("success"));
    }
}
