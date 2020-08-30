package com.hb;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * @author hb
 * @create 2020-08-09 10:42
 */
public class RabbitMQUtils {

    private static ConnectionFactory connectionFactory;
    static {
        //重要资源只执行一次
        //创建连接工厂对象
        connectionFactory = new ConnectionFactory();
        //设置连接rabbit主机
        connectionFactory.setHost("192.168.188.135");
        //设置访问哪个虚拟主机
        connectionFactory.setVirtualHost("/ems");
        //设置访问虚拟主机的用户名和密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
    }

    //定义提供连接对象的方法
    public static Connection getConnection() {
        try {
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //关闭通道和连接对象
    public static void CloseConnectionAndChannel(Channel channel, Connection connection) {
        try {
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
