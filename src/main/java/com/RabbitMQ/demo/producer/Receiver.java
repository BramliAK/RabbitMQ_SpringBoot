package com.RabbitMQ.demo.producer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    @RabbitListener(queues="my.queue.key")
    public void recievedMessage(String msg) {
        System.out.println("Recieved Message: " + msg);
    }
    /*
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }*/
}
