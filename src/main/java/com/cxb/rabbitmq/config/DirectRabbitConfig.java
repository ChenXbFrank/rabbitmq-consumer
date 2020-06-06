package com.cxb.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectRabbitConfig {

    //队列 起名：TestDirectQueue
    @Bean
    public Queue TestDirectQueue() {
        return new Queue("TestDirectQueue",true);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("TestDirectExchange");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }


    /**
     *  这里新添加的，为了后面的测试
     * @return
     */
    @Bean
    public Queue TestDirectQueue1() {
        return new Queue("TestDirectQueue1",true);
    }

    @Bean
    DirectExchange TestDirectExchange1() {
        //  return new DirectExchange("TestDirectExchange",true,true);
        return new DirectExchange("TestDirectExchange1",true,false);
    }

    @Bean
    Binding bindingDirect1() {
        return BindingBuilder.bind(TestDirectQueue1()).to(TestDirectExchange1()).with("TestDirectRouting1");
    }
}
