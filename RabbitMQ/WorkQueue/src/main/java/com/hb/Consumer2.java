package com.hb;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author hb
 * @create 2020-08-09 11:15
 */
public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //队列只能存在一个消息
        channel.basicQos(1);
        channel.queueDeclare("work",true,false,false,null);
        channel.basicConsume("work",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2: "+new String(body));
                //开启手动确认 每次确认一个
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
