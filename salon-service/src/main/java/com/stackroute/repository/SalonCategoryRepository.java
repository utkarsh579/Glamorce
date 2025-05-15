package com.stackroute.repository;
import com.stackroute.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SalonCategoryRepository extends MongoRepository<Category,String> {

//    db.category.update({_id:"Hair"},{$pull:{'services':{'serviceName':'Hair straightening'}}});
    @Query("{_id:'?0'},{$pull:{'services':{'serviceName':'?1'}}}")
    Category deleteServiceByCategory(String categoryName, String serviceName);
}
