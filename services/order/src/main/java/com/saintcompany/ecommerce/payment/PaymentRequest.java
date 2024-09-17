package com.saintcompany.ecommerce.payment;

import java.math.BigDecimal;

import com.saintcompany.ecommerce.customer.CustomerResponse;
import com.saintcompany.ecommerce.order.PaymentMethod;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {

}
