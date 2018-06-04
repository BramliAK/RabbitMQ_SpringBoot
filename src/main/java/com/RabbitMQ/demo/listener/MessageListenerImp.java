package com.RabbitMQ.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.Date;

public class MessageListenerImp implements  MessageListener {


    @Override
    public void onMessage(String message) {
        System.out.println(new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Message Received:"+message);
        System.out.println(new Date());
    }

}
