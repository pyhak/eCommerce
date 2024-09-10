package com.saintcompany.ecommerce.orderline;

public record OrderLineRequest(
    Integer id,
    Integer orderId,
    Integer productId,
    double quantity
) {

}
