package com.stackroute.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.exceptions.CategoryAlreadyExistsException;
import com.stackroute.exceptions.CategoryNotFoundException;
import com.stackroute.exceptions.ServiceAlreadyExistsException;
import com.stackroute.model.Category;
import com.stackroute.model.Services;
import com.stackroute.service.ISalonCategoryService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@RestController
@RequestMapping("category")
//@CrossOrigin(origins = "http://localhost:4200")
public class SalonCategoryController {

    private ISalonCategoryService recoCategoryService;
    @Autowired
    public SalonCategoryController(ISalonCategoryService recoCategoryService){
        this.recoCategoryService = recoCategoryService;
    }
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/category")
    public ResponseEntity<?> addCategory (@RequestBody Category category , Services services) throws CategoryAlreadyExistsException {
        try {
            return new ResponseEntity<>(recoCategoryService.addCategory(category,services), HttpStatus.CREATED);
        }
        catch (CategoryAlreadyExistsException e) {
            throw new CategoryAlreadyExistsException();
        }
    }

    @PutMapping("/category/{categoryName}")
    public ResponseEntity <?> updateCategory (@RequestParam("service") String service,@RequestParam("serviceImage") MultipartFile file,
                                              @PathVariable String categoryName) throws CategoryNotFoundException, ServiceAlreadyExistsException, IOException {
        rabbitTemplate.convertAndSend("exchange_data", "salon-data", service);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Services services1 = objectMapper.readValue(service, Services.class);
            byte[] image = file.getBytes();
            services1.setServiceImage(image);
            return new ResponseEntity<>(recoCategoryService.updateCategory(services1,categoryName),HttpStatus.OK);
        } catch (CategoryNotFoundException e) {
            throw new CategoryNotFoundException();
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategory(){
        return new ResponseEntity<>(recoCategoryService.getAllCategory(),HttpStatus.OK);
    }

    @GetMapping("/services")
    public ResponseEntity<?> getAllServices(){
        return new ResponseEntity<>(recoCategoryService.getAllServices(),HttpStatus.OK);
    }
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<?> getCategoryByName(@PathVariable String categoryName){
        return new ResponseEntity<>(recoCategoryService.getCategoryByName(categoryName),HttpStatus.OK);
    }

    @DeleteMapping("/category/{categoryName}")
    public ResponseEntity<?> deleteCategory(@PathVariable String categoryName) throws CategoryNotFoundException {
        try {
            return new ResponseEntity<>(recoCategoryService.deleteCategory(categoryName),HttpStatus.GONE);
        } catch (CategoryNotFoundException e) {
            throw new CategoryNotFoundException();
        }
    }

    @PutMapping("/category/{categoryName}/service/{serviceName}")
    public ResponseEntity<?> deleteServiceByCategory(@PathVariable String categoryName,@PathVariable String serviceName) throws CategoryNotFoundException {
            return new ResponseEntity<>(recoCategoryService.deleteServiceByCategory(categoryName,serviceName),HttpStatus.OK);
    }

}
