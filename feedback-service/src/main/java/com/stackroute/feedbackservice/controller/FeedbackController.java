package com.stackroute.feedbackservice.controller;
import com.stackroute.feedbackservice.exception.AppointmentIdNotFound;
import com.stackroute.feedbackservice.model.Feedback;
import com.stackroute.feedbackservice.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/feedback-app-v1")
public class FeedbackController
{

    FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService)
    {
      this.feedbackService=feedbackService;
    }


    //    [http://localhost:8083/feedback-app-v1/add-feedback]
    @PostMapping("/add-feedback")
    public ResponseEntity<?> addFeedback(@Valid @RequestBody Feedback feedback) throws AppointmentIdNotFound {
        try {
            return new ResponseEntity<>(feedbackService.addFeedback(feedback), HttpStatus.OK);
        } catch (AppointmentIdNotFound e) {
            throw new AppointmentIdNotFound();
        }
    }
//    [http://localhost:8083/feedback-app-v1/get-all-feedbacks]
    @GetMapping("/get-all-feedbacks")
    public ResponseEntity<?> getAllFeedbacks()
    {
        return new ResponseEntity<>(feedbackService.getAllFeedbacks(),HttpStatus.OK);
    }

    //    [http://localhost:8083/feedback-app-v1/delete-feedback]

    @DeleteMapping("/delete-feedback/{appointmentId}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String appointmentId) throws AppointmentIdNotFound  {
        try {
            return new ResponseEntity<>(feedbackService.deleteFeedback(appointmentId),HttpStatus.OK);
        } catch (AppointmentIdNotFound e) {
            throw new AppointmentIdNotFound();
        }
    }
}
