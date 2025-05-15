//package com.stackroute.feedbackservice;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.feedbackservice.controller.FeedbackController;
//import com.stackroute.feedbackservice.exception.AppointmentIdNotFound;
//import com.stackroute.feedbackservice.model.Feedback;
//import com.stackroute.feedbackservice.service.FeedbackService;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class FeedbackControllerTest
//{
//@Autowired
//private MockMvc mockMvc;
//
//@Mock
//private FeedbackService feedbackService;
//
//@InjectMocks
//private FeedbackController feedbackController;
//
//private Feedback feedback;
//
// @BeforeEach
// public void setup(){
//     feedback=new Feedback("005","Vaibhav","Good service",5);
//     mockMvc= MockMvcBuilders.standaloneSetup(feedbackController).build();
// }
//
// @AfterEach
// public void clean(){
//     feedback=null;
// }
//
// @Test
// public void testControllerAddFeedbackSuccess() throws Exception {
//     when(feedbackService.addFeedback(feedback)).thenReturn(feedback);
//     mockMvc.perform(
//             post("/feedback-app-v1/add-feedback")
//                     .contentType(MediaType.APPLICATION_JSON)
//                     .content(convertToJson(feedback)))
//             .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//     verify(feedbackService,times(1)).addFeedback(feedback);
//
// }
//
// @Test
// public void testControllerAddFeedbackFailure() throws Exception {
//     when(feedbackService.addFeedback(feedback)).thenThrow(AppointmentIdNotFound.class);
//     mockMvc.perform(
//                     post("/feedback-app-v1/add-feedback")
//                             .contentType(MediaType.APPLICATION_JSON)
//                             .content(convertToJson(feedback)))
//             .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//     verify(feedbackService,times(1)).addFeedback(feedback);
//
// }
//
//
// @Test
// public void testControllerDeleteFeedbackSuccess() throws Exception{
//     when(feedbackService.deleteFeedback(feedback.getAppointmentId())).thenReturn(true);
//     mockMvc.perform(
//                     delete("/feedback-app-v1/delete-feedback/005"))
//             .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//     verify(feedbackService,times(1)).deleteFeedback(feedback.getAppointmentId());
//
// }
//
//    @Test
//    public void testControllerDeleteFeedbackFailure() throws Exception{
//        when(feedbackService.deleteFeedback(feedback.getAppointmentId())).thenThrow(AppointmentIdNotFound.class);
//        mockMvc.perform(
//                        delete("/feedback-app-v1/delete-feedback/005"))
//                .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//        verify(feedbackService,times(1)).deleteFeedback(feedback.getAppointmentId());
//
//    }
//
//
//    public static String convertToJson(final Object object)
//    {
//        String result="";
//        ObjectMapper mapper=new ObjectMapper();
//        try{
//            result= mapper.writeValueAsString(object);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//}
