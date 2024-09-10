package com.saintcompany.ecommerce.orderline;

import org.springframework.stereotype.Service;

import com.saintcompany.ecommerce.order.Order;

@Service
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest request) {
    return OrderLine.builder()
        .id(request.id())
        .quantity(request.quantity())
        .order(
            Order.builder()
                .id(request.orderId())
                .build()
        )
        .productId(request.productId())
        .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderline) {
        return new OrderLineResponse(orderline.getId(), orderline.getQuantity());
        
    }

}
