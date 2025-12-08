package com.rizkyjayusman.product.controller;

import com.rizkyjayusman.product.dto.CheckStockRequest;
import com.rizkyjayusman.product.dto.CheckStockResponse;
import com.rizkyjayusman.product.dto.CreateProductRequest;
import com.rizkyjayusman.product.dto.ProductResponse;
import com.rizkyjayusman.product.entity.Product;
import com.rizkyjayusman.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getProduct(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @PostMapping("/stock/check")
    public CheckStockResponse checkStock(@RequestBody CheckStockRequest request) {
        return productService.checkStock(request);
    }

    @PostMapping("/stock/decrease")
    public void decreaseStock(@RequestBody CheckStockRequest request) {
        productService.decreaseStock(request);
    }
}
