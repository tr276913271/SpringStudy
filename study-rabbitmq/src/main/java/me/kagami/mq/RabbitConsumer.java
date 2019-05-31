package me.kagami.mq;

import com.rabbitmq.client.ConnectionFactory;

public class RabbitConsumer {
    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = "routingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "127.0.0.1";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
    }
}
