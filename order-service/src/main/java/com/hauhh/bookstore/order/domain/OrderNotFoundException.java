package com.hauhh.bookstore.order.domain;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }

    public static OrderNotFoundException forOrder(String orderNumber) {
        return new OrderNotFoundException("Order with number " + orderNumber + " not found");
    }
}
