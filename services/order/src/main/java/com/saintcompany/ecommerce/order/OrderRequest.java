package com.saintcompany.ecommerce.order;

import java.math.BigDecimal;
import java.util.List;

import com.saintcompany.ecommerce.product.PurchaseRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest (
    Integer id,
    String reference,
    @Positive(message = "Order amount should be positive")
    BigDecimal amount,
    @NotNull(message = "Payment method should be precised")
    PaymentMethod paymentMethod,
    @NotNull(message = "Customer should be present")
    @NotEmpty(message = "Customer should be present")
    @NotBlank(message = "Customer should be present")
    String customerId,
    @NotEmpty(message = "You should purchase at least one product")
    List<PurchaseRequest> products
) {

}
