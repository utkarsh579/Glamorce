//package com.stackroute.feedbackservice;
//
//
//import com.stackroute.feedbackservice.model.Feedback;
//import com.stackroute.feedbackservice.repository.FeedbackRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class FeedbackRepositoryTest
//{
//   private Feedback feedback;
//
//    @Autowired
//    private FeedbackRepository feedbackRepository;
//
//    @BeforeEach
//    public void setup(){
//        feedback=new Feedback("005","Vaibhav","Good service",5);
//    }
//
//    @AfterEach
//    public void clean(){
//        feedback=null;
//        feedbackRepository.deleteAll();
//    }
//
//    @Test
//    public void saveFeedbackTest(){
//        Feedback result= feedbackRepository.insert(feedback);
//        assertEquals(result,feedback);
//    }
//
//    @Test
//    public void getFeedbackTest(){
//        Feedback res=feedbackRepository.insert(feedback);
//        feedback.setAppointmentId("006");
//        Feedback res2= feedbackRepository.insert(feedback);
//        List<Feedback> list = feedbackRepository.findAll();
//        assertEquals(2,list.size());
//    }
//
//}
