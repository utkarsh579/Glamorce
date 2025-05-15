package com.stackroute.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.exceptions.EmployeeAlreadyExistsException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;
import com.stackroute.service.IEmployeeService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("employee")
//@CrossOrigin(origins = "*")
public class EmployeeController {

    private IEmployeeService employeeService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    public EmployeeController(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public ResponseEntity<?> registerEmployee (@Valid @RequestParam("employee") String employee, @RequestParam("profilePhoto") MultipartFile file ) throws EmployeeAlreadyExistsException, IOException {

        rabbitTemplate.convertAndSend("exchange_data","register-employee",employee);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Employee employee1 = objectMapper.readValue(employee, Employee.class);
            byte[] image = file.getBytes();
            employee1.setProfilePhoto(image);
            return new ResponseEntity<>(employeeService.registerEmployee(employee1), HttpStatus.OK);
        }
        catch (EmployeeAlreadyExistsException | JsonProcessingException e) {
            throw new EmployeeAlreadyExistsException();
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
    }
    @GetMapping("/employee/{employeeEmail}")
    public ResponseEntity<?> getOneEmployee(@PathVariable String employeeEmail) throws EmployeeNotFoundException {
        Employee employee = employeeService.getOneEmployee(employeeEmail);
        if(employee==null)
            throw new EmployeeNotFoundException();
        else
            return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @GetMapping("/employees/{proficiency}")
    public ResponseEntity<?>getEmployeeByProficiency(@PathVariable String proficiency) throws EmployeeNotFoundException {
        try {
            return new ResponseEntity<>(employeeService.getEmployeeByProficiency(proficiency),HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }
    }

    @DeleteMapping("/employee/{email}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String email) throws EmployeeNotFoundException {
        try {
            return new ResponseEntity<>(employeeService.deleteEmployee(email),HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }
    }

    @PutMapping("/employee/{email}")
    public ResponseEntity<?> updateEmployee(@Valid @RequestParam("employee") String employee , @RequestParam("profilePhoto") MultipartFile file, @PathVariable String email) throws EmployeeNotFoundException, IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Employee employee1 = objectMapper.readValue(employee, Employee.class);
            byte[] image = file.getBytes();
            employee1.setProfilePhoto(image);
            return new ResponseEntity<>(employeeService.updateEmployee(employee1, email),HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }
    }




}
