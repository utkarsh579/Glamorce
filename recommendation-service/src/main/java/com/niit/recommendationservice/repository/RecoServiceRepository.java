package com.niit.recommendationservice.repository;
import com.niit.recommendationservice.model.Services;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecoServiceRepository extends Neo4jRepository<Services,String> {

    @Query("MATCH (:Category{categoryName:$categoryName})-[:SERVICES]->(service:Services) RETURN service")
    List<Services> findServicesByCategory(String categoryName);

}
