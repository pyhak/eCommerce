package com.saintcompany.ecommerce.kafka.order;

import java.math.BigDecimal;

public record OrderConfirmation(
    String orderReference,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    Customer customer,
    List<Product> products
) {

}
