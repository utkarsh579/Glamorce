package com.stackroute.feedbackservice.service;

import com.stackroute.feedbackservice.exception.AppointmentIdNotFound;
import com.stackroute.feedbackservice.model.Feedback;
import java.util.List;

public interface FeedbackService
{
    Feedback addFeedback(Feedback feedback) throws AppointmentIdNotFound;

     List<Feedback> getAllFeedbacks();

     boolean deleteFeedback(String appointmentId) throws AppointmentIdNotFound;

}
