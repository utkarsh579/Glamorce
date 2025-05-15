package com.niit.recommendationservice.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.recommendationservice.exceptions.ServiceAlreadyExistsException;
import com.niit.recommendationservice.exceptions.ServiceNotFoundException;
import com.niit.recommendationservice.model.Services;
import com.niit.recommendationservice.service.IRecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:4200")
public class RecoServiceController {

    private IRecoService recoService;
    @Autowired
    public RecoServiceController(IRecoService recoService){
        this.recoService = recoService;
    }

    @PostMapping("/service")
    public ResponseEntity<?> addService (@RequestBody Services services) throws ServiceAlreadyExistsException {
        try {
            return new ResponseEntity<>(recoService.addService(services), HttpStatus.CREATED);
        }
        catch (ServiceAlreadyExistsException e) {
            throw new ServiceAlreadyExistsException();
        }
    }

    @GetMapping("/services")
    public ResponseEntity<?> getAllServices(){
        return new ResponseEntity<>(recoService.getAllService(),HttpStatus.OK);
    }

    @DeleteMapping("/service/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable String serviceId) throws ServiceNotFoundException {
        try {
            return new ResponseEntity<>(recoService.deleteService(serviceId),HttpStatus.GONE);
        } catch (ServiceNotFoundException e) {
            throw new ServiceNotFoundException();
        }
    }

    @PutMapping("/service/{serviceId}")
    public ResponseEntity<?> updateUser(@RequestParam("services") String services , @RequestParam("serviceImage") MultipartFile file,
                                        @PathVariable String serviceId) throws ServiceNotFoundException{
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Services services1 = objectMapper.readValue(services, Services.class);
            byte[] image = file.getBytes();
            services1.setServiceImage(image);
            return new ResponseEntity<>(recoService.updateServices(services1, serviceId),HttpStatus.OK);
        } catch (ServiceNotFoundException | IOException e) {
            throw new ServiceNotFoundException();
        }
    }

    @GetMapping("/services/{categoryName}")
    public ResponseEntity<?> findServicesByCategory(@PathVariable String categoryName){
        return new ResponseEntity<>(recoService.findServicesByCategory(categoryName),HttpStatus.FOUND);
    }

}
