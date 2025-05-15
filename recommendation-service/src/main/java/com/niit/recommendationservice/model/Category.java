package com.niit.recommendationservice.model;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Node
public class Category {

    @Id
    private String categoryName;
    private List<Services> services;

}
