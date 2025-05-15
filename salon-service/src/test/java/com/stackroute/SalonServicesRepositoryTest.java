//package com.stackroute;
//
//import com.stackroute.model.Services;
//import com.stackroute.repository.SalonServicesRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@DataMongoTest
//@ExtendWith(SpringExtension.class)
//public class SalonServicesRepositoryTest {
//    @Autowired
//    private SalonServicesRepository salonServicesRepository;
//
//    private Services services;
//
//
//    @BeforeEach
//    void setUp() {
//
//        this.services = new Services("S001", "Haircut", "20", "200", "very nice Haircut", (byte) 1);
//    }
//
//    @AfterEach
//    void clear() {
//
//        this.services = null;
//    }
//
//    @Test
//    @DisplayName("Test case for saving service object")
//    void givenServiceSaveReturnsServiceSaved() {
//        salonServicesRepository.save(services);
//        Services services1 = salonServicesRepository.findById(services.getServiceId()).get();
//        assertNotNull(services1);
//        assertEquals(services.getServiceId(), services1.getServiceId());
//    }
//
//    @Test
//    @DisplayName("Test case for deleting Service object")
//    void givenServiceDeleteReturnsServiceDeleted() {
//        salonServicesRepository.save(services);
//        Services services1 = salonServicesRepository.findById(services.getServiceId()).get();
//        salonServicesRepository.delete(services1);
//        assertEquals(Optional.empty(), salonServicesRepository.findById(services1.getServiceId()));
//
//    }
//
//
//
//    @Test
//    @DisplayName("Test case for getting all Services")
//    public void givenUserForGetAllUserObject(){
//        salonServicesRepository.save(services);
//        Services services1 = new Services("S001", "Haircut", "20", "200", "very nice Haircut", (byte) 1);
//        salonServicesRepository.save(services1);
//        List<Services> servicesList = salonServicesRepository.findAll();
//        assertEquals(3,servicesList.size());
//        assertEquals("S001",servicesList.get(1).getServiceId());
//    }
//
//}