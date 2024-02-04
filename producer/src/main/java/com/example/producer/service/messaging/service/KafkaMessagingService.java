package com.example.producer.service.messaging.service;

import com.example.producer.service.messaging.event.OrderSendEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Service
@RequiredArgsConstructor
public class KafkaMessagingService {

    @Value("${topic.send-order}") //внедряем название топика из application.yml
    private String sendClientTopic;

    private final KafkaTemplate<String , Object> kafkaTemplate;
    // KafKaTemplate нужен чтобы отправлять сообщения
    // Первый параметр – это тип ключа, второй – самого сообщения

    //метод по отправке сообщения(заказа): 1)название топика, 2)ключ(штрихкод продукта), 3)сам заказ
    public void sendOrder(OrderSendEvent orderSendEvent) {
        kafkaTemplate.send(sendClientTopic, orderSendEvent.getBarCode(), orderSendEvent);
    }
}
