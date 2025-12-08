package com.rizkyjayusman.order.client;

import com.rizkyjayusman.order.dto.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class ProductClient {

    private final RestTemplate rest = new RestTemplate();

    @Value("${internal-services.product-service.base-url}")
    private String baseUrl;

    public boolean checkStock(List<CreateOrderRequest.Item> items) {
        String url = baseUrl + "/api/v1/products/stock/check";
        Map<String, Object> body = Map.of("items", items);
        Map<String, Object> result = rest.postForObject(url, body, Map.class);
        return Boolean.TRUE.equals(result.get("success"));
    }

    public boolean decreaseStock(List<CreateOrderRequest.Item> items) {
        String url = baseUrl + "/api/v1/products/stock/decrease";
        Map<String, Object> body = Map.of("items", items);
        ResponseEntity<Void> response = rest.postForEntity(url, body, Void.class);
        return response.getStatusCode().is2xxSuccessful();
    }
}
