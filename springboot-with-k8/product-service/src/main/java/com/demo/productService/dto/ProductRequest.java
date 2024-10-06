package com.demo.productService.dto;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String description, String skuCode, BigDecimal price) {
}
