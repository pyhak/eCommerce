package com.saintcompany.ecommerce.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest (
    Integer id,
    
    @NotNull(message = "Product Name is required")
    String Name,

    @NotNull(message = "Product description is required")
    String description,

    @Positive(message = "Available quantity should be poisitive")
    double availableQuantity,
    
    @Positive(message = "Price should be poisitive")
    BigDecimal price,
    
    @NotNull(message = "Category is required")
    Integer categoryId
)
{}

