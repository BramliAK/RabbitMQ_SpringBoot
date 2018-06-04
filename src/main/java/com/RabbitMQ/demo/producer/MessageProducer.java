package com.RabbitMQ.demo.producer;

import com.RabbitMQ.demo.config.RobbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {

        System.out.println(new Date());
        rabbitTemplate.convertAndSend(RobbitMqConfig.ROUTING_KEY, message);
        System.out.println("Is listener returned ::: "+rabbitTemplate.isReturnListener());

    }
}
