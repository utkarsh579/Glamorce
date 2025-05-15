//package com.stackroute;
//
//
//import com.stackroute.exception.ServiceNotAddedException;
//import com.stackroute.exception.ServiceNotFoundException;
//import com.stackroute.model.Services;
//import com.stackroute.repository.SalonServicesRepository;
//import com.stackroute.service.SalonServicesServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class SalonServicesServiceTest
//
//{
//    @Mock
//    private SalonServicesRepository salonServicesRepository;
//    @InjectMocks
//    private SalonServicesServiceImpl salonServicesService;
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
//    public void addServiceSuccess() throws ServiceNotAddedException {
//        when(salonServicesRepository.findById(services.getServiceId())).thenReturn(Optional.ofNullable(null));
//        when(salonServicesRepository.save(services)).thenReturn(services);
//        assertEquals(services,salonServicesService.addService(services));
//        verify(salonServicesRepository,times(1)).save(any());
//        verify(salonServicesRepository,times(1)).findById(any());
//    }
//    @Test
//    public void addServiceFailure() {
//        when(salonServicesRepository.findById(services.getServiceId())).thenReturn(Optional.ofNullable(services));
//        assertThrows(ServiceNotAddedException.class,()->salonServicesService.addService(services));
//        verify(salonServicesRepository,times(0)).save(any());
//        verify(salonServicesRepository,times(1)).findById(any());
//    }
//    @Test
//    public void deleteServiceSuccess() throws ServiceNotFoundException {
//        when(salonServicesRepository.findById(services.getServiceId())).thenReturn(Optional.ofNullable(services));
//        String result = salonServicesService.deleteService(services.getServiceId());
//        assertEquals("Service Deleted",result);
//        verify(salonServicesRepository,times(1)).deleteById(any());
//        verify(salonServicesRepository,times(1)).findById(any());
//    }
//    @Test
//    public void deleteServiceFailure() {
//        when(salonServicesRepository.findById(services.getServiceId())).thenReturn(Optional.ofNullable(null));
//        assertThrows(ServiceNotFoundException.class,()->salonServicesService.deleteService(services.getServiceId()));
//        verify(salonServicesRepository,times(0)).deleteById(any());
//        verify(salonServicesRepository,times(1)).findById(any());
//    }
//
//
//    @Test
//    public void getAllServicesSuccess(){
//        when(salonServicesRepository.findAll()).thenReturn(List.of(new Services("S001", "Haircut", "20", "200", "very nice Haircut", (byte) 1)));
//        assertEquals(List.of(new Services("S001", "Haircut", "20", "200", "very nice Haircut", (byte) 1)),salonServicesService.getAllServices());
//        verify(salonServicesRepository,times(1)).findAll();
//    }
//
//    @Test
//    public void getAllServicesFailure(){
//        when(salonServicesRepository.findAll()).thenReturn(List.of());
//        assertEquals(List.of(),salonServicesService.getAllServices());
//        verify(salonServicesRepository,times(1)).findAll();
//    }
//}
