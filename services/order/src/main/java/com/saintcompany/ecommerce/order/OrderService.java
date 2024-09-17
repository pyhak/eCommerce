package com.saintcompany.ecommerce.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.saintcompany.ecommerce.customer.CustomerClient;
import com.saintcompany.ecommerce.customer.CustomerResponse;
import com.saintcompany.ecommerce.exception.BusinessException;
import com.saintcompany.ecommerce.kafka.OrderConfirmation;
import com.saintcompany.ecommerce.kafka.OrderProducer;
import com.saintcompany.ecommerce.orderline.OrderLineRequest;
import com.saintcompany.ecommerce.orderline.OrderLineService;
import com.saintcompany.ecommerce.payment.PaymentClient;
import com.saintcompany.ecommerce.payment.PaymentRequest;
import com.saintcompany.ecommerce.product.ProductClient;
import com.saintcompany.ecommerce.product.PurchaseRequest;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest request) {
        // check customer --> Openfeign
        CustomerResponse customer = this.customerClient.findCustomerById(request.customerId())
            .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with ID: " + request.customerId()));


        //purchase the products --> product-ms (RestTemplate)
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        //persist order lines
        var order = this.orderRepository.save(mapper.toOrder(request));

        for(PurchaseRequest purchaseRequest: request.products()) {
            orderLineService.saveOrderLine(
                new OrderLineRequest(
                    null,
                    order.getId(),
                    purchaseRequest.productId(),
                    purchaseRequest.quantity()
                )
            );
        }

        //todo start payment process
        var paymentRequest = new PaymentRequest(
            request.amount(), 
            request.paymentMethod(), 
            order.getId(), 
            order.getReference(), 
            customer);

        paymentClient.requestOrderPayment(paymentRequest);

        // send the order confirmation --> notification-ms (kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                    request.reference(),
                    request.amount(),
                    request.paymentMethod(),
                    customer,
                    purchasedProducts
                )
            );

        return order.getId();
    }

    public List<OrderResponse> findAll() {
    return orderRepository.findAll()
        .stream()
        .map(mapper::fromOrder)
        .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer id) {
        return orderRepository.findById(id).map(mapper::fromOrder)
        .orElseThrow(() -> new EntityNotFoundException(String.format("Order not found with Id::%d", id)));
    }

}
