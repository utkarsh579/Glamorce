package com.stackroute.feedbackservice.repository;

import com.stackroute.feedbackservice.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepository extends MongoRepository<Feedback, String>
{

}
