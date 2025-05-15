package com.stackroute.rabbitMQ;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;

@Configuration
public class MessageConfig {
    private String queue_name1 = "user-queue";
    private String queue_name2 = "employee-queue";
    private String queue_name3 = "mail_queue";
    private String exchange_name = "exchange_data";

    @Bean
    public Queue queue() {
        return new Queue(queue_name1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(queue_name2);
    }

    @Bean
    public Queue queue3() {
        return new Queue(queue_name3);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange_name);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("register-user");
    }

    @Bean
    public Binding binding2(Queue queue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue2).to(topicExchange).with("register-employee");
    }

    @Bean
    public Binding binding3(Queue queue3, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue3).to(topicExchange).with("email-send");
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}


