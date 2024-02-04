package com.example.producer.service.messaging.producer;
/*
нужен для того чтобы отделить логику отправки от маппинга сущностей.
 */

import com.example.producer.model.Order;
import com.example.producer.service.messaging.event.OrderSendEvent;
import com.example.producer.service.messaging.service.KafkaMessagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {

    private final KafkaMessagingService kafkaMessagingService;
    private final ModelMapper modelMapper;

    public Order sendOrderEvent(Order order) {
        kafkaMessagingService.sendOrder(modelMapper.map(order, OrderSendEvent.class));
        log.info("Отправка заказа из продюсера {}", order);
        return order;
    }
}
