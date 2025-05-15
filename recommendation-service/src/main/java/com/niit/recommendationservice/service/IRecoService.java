package com.niit.recommendationservice.service;
import com.niit.recommendationservice.exceptions.ServiceAlreadyExistsException;
import com.niit.recommendationservice.exceptions.ServiceNotFoundException;
import com.niit.recommendationservice.model.Services;
import java.util.List;

public interface IRecoService {

    Services addService (Services service) throws ServiceAlreadyExistsException;
    List<Services> getAllService();
    String deleteService (String serviceId) throws ServiceNotFoundException;
    Services updateServices(Services services, String serviceId) throws ServiceNotFoundException;

    List<Services> findServicesByCategory (String categoryName);

}
