package com.rizkyjayusman.product.service;

import com.rizkyjayusman.product.dto.CheckStockRequest;
import com.rizkyjayusman.product.dto.CheckStockResponse;
import com.rizkyjayusman.product.entity.Product;
import com.rizkyjayusman.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public CheckStockResponse checkStock(CheckStockRequest request) {
        List<Long> ids = request.getItems().stream()
                .map(CheckStockRequest.Item::getProductId)
                .collect(Collectors.toList());

        List<Product> products = productRepository.findByIdIn(ids);
        Map<Long, Product> map = products.stream().collect(Collectors.toMap(Product::getId, p -> p));

        List<CheckStockResponse.FailedItem> failed = new ArrayList<>();

        for (CheckStockRequest.Item item : request.getItems()) {
            Product p = map.get(item.getProductId());
            if (p == null || p.getStock() < item.getQuantity()) {
                failed.add(new CheckStockResponse.FailedItem(
                        item.getProductId(),
                        item.getQuantity(),
                        p != null ? p.getStock() : 0
                ));
            }
        }

        boolean ok = failed.isEmpty();
        return CheckStockResponse.builder()
                .success(ok)
                .failed(failed)
                .build();
    }

    @Transactional
    public void decreaseStock(CheckStockRequest request) {
        List<Long> ids = request.getItems().stream()
                .map(CheckStockRequest.Item::getProductId)
                .collect(Collectors.toList());

        List<Product> products = productRepository.findByIdIn(ids);
        Map<Long, Product> map = products.stream().collect(Collectors.toMap(Product::getId, p -> p));

        for (CheckStockRequest.Item item : request.getItems()) {
            Product p = map.get(item.getProductId());
            if (p != null) {
                p.setStock(p.getStock() - item.getQuantity());
            }
        }

        productRepository.saveAll(products);
    }
}
