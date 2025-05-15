package com.stackroute.feedbackservice.service;
import com.stackroute.feedbackservice.exception.AppointmentIdNotFound;
import com.stackroute.feedbackservice.model.Feedback;
import com.stackroute.feedbackservice.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.stackroute.feedbackservice.model.Feedback.SEQUENCE_NAME;


@Service
public class FeedbackServiceImpl implements FeedbackService
{

    FeedbackRepository feedbackRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository)
    {
        this.feedbackRepository=feedbackRepository;
    }

    @Override
    public Feedback addFeedback(Feedback feedback) throws AppointmentIdNotFound
    {
//        if(feedbackRepository.findById(feedback.getAppointmentId()).isEmpty())
//        {
            String c="FID";
            String id= String.valueOf(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
            feedback.setFeedBackId(c+id);
           return feedbackRepository.insert(feedback);
//        }
//
//        else
//            throw new AppointmentIdNotFound();

    }

    @Override
    public List<Feedback> getAllFeedbacks()
    {

        return feedbackRepository.findAll();
    }

    @Override
    public boolean deleteFeedback(String appointmentId) throws AppointmentIdNotFound
    {
        if(feedbackRepository.findById(appointmentId).isPresent())
        {
            feedbackRepository.deleteById(appointmentId);
            return true;
        }
        else
           throw new AppointmentIdNotFound();

    }
}
