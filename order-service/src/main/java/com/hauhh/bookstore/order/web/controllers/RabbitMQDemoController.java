package com.hauhh.bookstore.order.web.controllers;

import com.hauhh.bookstore.order.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RabbitMQDemoController {

    private final RabbitTemplate rabbitTemplate;
    private final ApplicationProperties properties;

    @PostMapping("/send")
    public void sendMessage(@RequestBody MyMessage message) {
        rabbitTemplate.convertAndSend(
                properties.orderEventsExchange(),
                message.routingKey(),
                message.payload()
        );
    }

}

record MyMessage(String routingKey, MyPayload payload) {

}


record MyPayload(String content) {

}
