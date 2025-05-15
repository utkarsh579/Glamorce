package com.stackroute.service;
import com.stackroute.exceptions.EmployeeAlreadyExistsException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee registerEmployee (Employee employee) throws EmployeeAlreadyExistsException;
    List<Employee> getAllEmployee();
    String deleteEmployee(String email) throws EmployeeNotFoundException;
    Employee updateEmployee(Employee employee, String email) throws EmployeeNotFoundException;
    Employee getOneEmployee(String employeeEmail) throws EmployeeNotFoundException ;
    List<Employee> getEmployeeByProficiency(String proficiency) throws EmployeeNotFoundException ;


}
