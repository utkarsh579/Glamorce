//package com.stackroute.paymentservice.rabbitMq;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ProducerMessageConfiguration {
//    private String queue_name1="mail_queue";
//    private String exchange_name="exchange_data";
//
//    @Bean
//    public Queue queue()
//    {
//        return new Queue(queue_name1);
//    }
//
//    @Bean
//    public TopicExchange exchange()
//    {
//        return new TopicExchange(exchange_name);
//    }
//    @Bean
//    public Binding binding(Queue queue, TopicExchange topicExchange)
//    {
//        return BindingBuilder.bind(queue).to(topicExchange).with("Payment");
//    }
//
//    @Bean
//    public MessageConverter converter()
//    {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public AmqpTemplate template(ConnectionFactory connectionFactory)
//    {
//        final RabbitTemplate rabbitTemplate= new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(converter());
//        return rabbitTemplate;
//    }
//}
