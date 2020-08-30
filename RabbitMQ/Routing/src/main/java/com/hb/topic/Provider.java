package com.hb.topic;

import com.hb.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author hb
 * @create 2020-08-28 18:33
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //声命交换机和交换机类型 topic 使用动态路由(通配符方式)
        channel.exchangeDeclare("topics","topic");
        //动态路由key
        String routingkey="user.save.test";
        //发布消息
        channel.basicPublish("topics",routingkey,null,("这是路由中的动态订阅模型,route key: ["+routingkey+"]").getBytes());
        RabbitMQUtils.CloseConnectionAndChannel(channel,connection);
    }
}
