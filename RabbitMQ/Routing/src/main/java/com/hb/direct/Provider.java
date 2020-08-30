package com.hb.direct;

import com.hb.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author hb
 * @create 2020-08-28 18:04
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //通过通道声明交换机
        channel.exchangeDeclare("logs_direct","direct");
        //发送消息
        String routingkey="error";
        channel.basicPublish("logs_direct",routingkey,null,("指定route key:"+routingkey+"的direct消息").getBytes());
        RabbitMQUtils.CloseConnectionAndChannel(channel,connection);
    }
}
