package com.saintcompany.ecommerce.product;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String Name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Integer categoryId,
        String categoryName,
        String CategoryDescription
){}
