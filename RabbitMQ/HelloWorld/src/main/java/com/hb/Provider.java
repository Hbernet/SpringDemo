package com.hb;

import com.hb.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author hb
 * @create 2020-08-09 9:56
 */
public class Provider {
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        // 获取连接通道
        Channel channel = connection.createChannel();
        //通道绑定消息队列
        // 参数1 如果队列不存在自动创建 参数2是否持久化（durable） 参数3 是否独占队列（exclusive）
        //参数4 是否在消费之后自动删除（autoDelete）参数5 其他参数
        channel.queueDeclare("hello", false, false, false, null);
        //发布消息 参数 交换机名称 队列名称 传递消息的额外设置 消息具体内容字节类型
        channel.basicPublish("", "hello", null, "hello world queue".getBytes());
        RabbitMQUtils.CloseConnectionAndChannel(channel,connection);
    }
}
