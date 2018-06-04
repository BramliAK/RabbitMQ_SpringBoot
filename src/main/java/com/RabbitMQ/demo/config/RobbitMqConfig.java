package com.RabbitMQ.demo.config;

import com.RabbitMQ.demo.listener.MessageListenerImp;
import com.RabbitMQ.demo.producer.Receiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobbitMqConfig {
    public static final String ROUTING_KEY = "my.queue.key";

    @Bean
    Queue queue() {
        return new Queue(ROUTING_KEY, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("my_queue_exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
    /*@Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(ROUTING_KEY);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter( Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }*/

}
