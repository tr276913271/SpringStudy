package me.kagami.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitProducer {

    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = "routingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "127.0.0.1";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        //设置rabbotMQ相关信息
        factory.setHost(IP_ADDRESS);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
        //创建新的连接
        Connection connection = factory.newConnection();
        //创建新的通道
        Channel channel = connection.createChannel();
        //持久化的，非自动删除
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, "Hello".getBytes());
        channel.close();
        connection.close();
    }
}
