package org.lee.spring.cloud.alibaba.rocketmq.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding({ Source.class })
public class RocketMQProviderApplication implements CommandLineRunner {

    @Autowired
    private MessageChannel output; // 获取name为output的binding

    public static void main(String[] args) {
        SpringApplication.run(RocketMQProviderApplication.class,args);
    }

    /**
     * 该接口的实现方法在springboot应用启动时自动执行，只用来测试demo使用
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        output.send(MessageBuilder.withPayload("Hello rocketMQ").build());//发一条消息
    }
}
