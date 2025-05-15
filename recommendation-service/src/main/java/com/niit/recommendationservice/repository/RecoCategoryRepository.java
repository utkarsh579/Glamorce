package com.niit.recommendationservice.repository;
import com.niit.recommendationservice.model.Category;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecoCategoryRepository extends Neo4jRepository<Category,String> {

}
