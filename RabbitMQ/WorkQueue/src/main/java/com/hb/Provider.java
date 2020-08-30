package com.hb;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author hb
 * @create 2020-08-09 11:05
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work", true, false, false, null);
        for (int i=0; i<20;i++){
            channel.basicPublish("","work",null,(i+"-hello work queue").getBytes());
        }
        RabbitMQUtils.CloseConnectionAndChannel(channel,connection);
    }
}
