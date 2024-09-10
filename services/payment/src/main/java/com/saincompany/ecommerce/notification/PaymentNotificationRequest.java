package com.saincompany.ecommerce.notification;

import java.math.BigDecimal;

import com.saincompany.ecommerce.payment.PaymentMethod;


public record PaymentNotificationRequest(
    String orderReference,
    BigDecimal amount,
    PaymentMethod paymentMethodString,
    String customerFirstName,
    String customerLastName,
    String customerEmail
) {

}
