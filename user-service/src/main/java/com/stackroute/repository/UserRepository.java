package com.stackroute.repository;
import com.stackroute.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends MongoRepository<User,String> {
//    @Query("{'_id' : '?0' },{'$set' : { 'name' : '?1' } }")
//    User updateNameOfUser(String _id,String name);
//
//    @Query("{'_id':'?0'}")
//    List<User> usersById(String _id);
}
