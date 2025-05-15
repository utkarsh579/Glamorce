//package com.stackroute.feedbackservice;
//
//import com.stackroute.feedbackservice.exception.AppointmentIdNotFound;
//import com.stackroute.feedbackservice.model.Feedback;
//import com.stackroute.feedbackservice.repository.FeedbackRepository;
//import com.stackroute.feedbackservice.service.FeedbackServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class FeedbackServiceTest
//{
//    @Mock
//    private FeedbackRepository feedbackRepository;
//
//    @InjectMocks
//    private FeedbackServiceImpl feedbackService;
//
//    private Feedback feedback;
//
//    @BeforeEach
//    public void setup(){
//        feedback=new Feedback("005","Vaibhav","Good Service",5);
//    }
//
//    @AfterEach
//    public void clean(){
//        feedback=null;
//    }
//
//    @Test
//    public void testAddFeedbackSuccess() throws AppointmentIdNotFound{
//        when(feedbackRepository.findById(feedback.getAppointmentId())).thenReturn(Optional.ofNullable(null));
//        when(feedbackRepository.insert(feedback)).thenReturn(feedback);
//        assertEquals(feedback,feedbackService.addFeedback(feedback));
//        verify(feedbackRepository,times(1)).findById((feedback.getAppointmentId()));
//        verify(feedbackRepository,times(1)).insert(feedback);
//    }
//
//    @Test
//    public void testAddFeedbackFailure() throws AppointmentIdNotFound{
//        when(feedbackRepository.findById(feedback.getAppointmentId())).thenReturn(Optional.of(feedback));
//        assertThrows(AppointmentIdNotFound.class,()->feedbackService.addFeedback(feedback));
//        verify(feedbackRepository,times(1)).findById(feedback.getAppointmentId());
//        verify(feedbackRepository,times(0)).insert(feedback);
//    }
//
//    @Test
//    public void testDeleteFeedbackSuccess() throws AppointmentIdNotFound{
//        when(feedbackRepository.findById(feedback.getAppointmentId())).thenReturn(Optional.of(feedback));
//        boolean result= feedbackService.deleteFeedback(feedback.getAppointmentId());
//        assertEquals(true,result);
//        verify(feedbackRepository,times(1)).findById(feedback.getAppointmentId());
//        verify(feedbackRepository,times(1)).deleteById(feedback.getAppointmentId());
//    }
//
//    @Test
//    public void testDeleteFeedbackFailure(){
//        when(feedbackRepository.findById(feedback.getAppointmentId())).thenReturn(Optional.ofNullable(null));
//        assertThrows(AppointmentIdNotFound.class,()->feedbackService.deleteFeedback(feedback.getAppointmentId()));
//        verify(feedbackRepository,times(1)).findById(feedback.getAppointmentId());
//        verify(feedbackRepository,times(0)).deleteById(feedback.getAppointmentId());
//    }
//}
