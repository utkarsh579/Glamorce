package com.stackroute.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "category")
public class Category {

    @Id
    @NotNull
    private String categoryName;
    private List<Services> services;

}
