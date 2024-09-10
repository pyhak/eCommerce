package com.saintcompany.ecommerce.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.saintcompany.ecommerce.customer.CustomerResponse;
import com.saintcompany.ecommerce.order.PaymentMethod;
import com.saintcompany.ecommerce.product.PurchaseResponse;


public record OrderConfirmation(
    String OrderReference,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    CustomerResponse customer,
    List<PurchaseResponse> products
) {

}
