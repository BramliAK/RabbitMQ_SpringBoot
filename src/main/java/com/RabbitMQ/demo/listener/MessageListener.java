package com.RabbitMQ.demo.listener;

public interface MessageListener {
    public void onMessage(String message);
}
