package com.niit.recommendationservice.model;
import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Services {

    @Id
    private String serviceId;
    private String serviceName;
    private int serviceTime;
    private int servicePrice;
    private String serviceDescription;
    private byte[] serviceImage;

}
