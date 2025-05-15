package com.niit.recommendationservice.service;
import com.niit.recommendationservice.exceptions.ServiceAlreadyExistsException;
import com.niit.recommendationservice.exceptions.ServiceNotFoundException;
import com.niit.recommendationservice.model.Services;
import com.niit.recommendationservice.repository.RecoServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class RecoServiceImpl implements IRecoService{

    @Autowired
    private RecoServiceRepository serviceRepository;

    @Override
    public Services addService(Services service) throws ServiceAlreadyExistsException {
        if (serviceRepository.findById(service.getServiceId()).isPresent()){
            throw new ServiceAlreadyExistsException();
        }
        return serviceRepository.save(service);
    }

    @Override
    public List<Services> getAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public String deleteService(String serviceId) throws ServiceNotFoundException {
        if (serviceRepository.findById(serviceId).isPresent()){
            serviceRepository.deleteById(serviceId);
            return "Service_Deleted";
        }
        throw new ServiceNotFoundException();
    }

    @Override
    public Services updateServices(Services services, String serviceId) throws ServiceNotFoundException {
        return serviceRepository.save(services);
    }

    @Override
    public List<Services> findServicesByCategory(String categoryName) {
        return serviceRepository.findServicesByCategory(categoryName);
    }
}
