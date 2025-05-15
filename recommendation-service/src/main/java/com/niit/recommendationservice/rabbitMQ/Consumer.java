package com.niit.recommendationservice.rabbitMQ;
import com.niit.recommendationservice.model.Category;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


public class Consumer {

    @RabbitListener(queues = "salon-queue")
    public void addCategory(Category category)  {
        System.out.println(category);
//        Category category1 = new Category(category.getCategoryName(),category.getServices());
    }

}
