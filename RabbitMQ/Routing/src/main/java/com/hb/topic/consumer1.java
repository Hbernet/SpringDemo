package com.hb.topic;

import com.hb.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author hb
 * @create 2020-08-28 18:38
 */
public class consumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare("topics","topic");
        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //绑定队列与交换机并设置获取交换机中动态路由  匹配不多不少恰好1个词
        channel.queueBind(queue,"topics","user.*");
        //消费消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1："+new String(body));
            }
        });
    }
}
