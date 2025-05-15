package com.stackroute.service;
import com.stackroute.exceptions.EmployeeAlreadyExistsException;
import com.stackroute.exceptions.EmployeeNotFoundException;
import com.stackroute.model.Employee;
import com.stackroute.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee registerEmployee(Employee employee) throws EmployeeAlreadyExistsException {
        if(employeeRepository.findById(employee.getEmployeeEmail()).isPresent()){
            throw new EmployeeAlreadyExistsException();
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public String deleteEmployee(String email) throws EmployeeNotFoundException {
        if(employeeRepository.findById(email).isEmpty()){
            throw new EmployeeNotFoundException();
        }
        employeeRepository.deleteById(email);
        return "Employee_Deleted";
    }

    @Override
    public Employee updateEmployee(Employee employee, String email) throws EmployeeNotFoundException {
        Optional<Employee> checkId = employeeRepository.findById(email);
        if (checkId.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        Employee result = checkId.get();
        if (employee.getAddress()!=null){
            result.setAddress(employee.getAddress());
        }
        if (employee.getEmployeePassword()!=null){
            result.setEmployeePassword(employee.getEmployeePassword());
        }
        if (employee.getName()!=null){
            result.setName(employee.getName());
        }
        if (employee.getAge()!=0){
            result.setAge(employee.getAge());
        }
        if (employee.getMobileNo()!=null){
            result.setMobileNo(employee.getMobileNo());
        }
        if (employee.getProfilePhoto()!=new byte[0]){
            result.setProfilePhoto(employee.getProfilePhoto());
        }
        if (employee.getGender()!=null){
            result.setGender(employee.getGender());
        }
        if (employee.getExperience()!=null){
            result.setExperience(employee.getExperience());
        }
        if (employee.getProficiency()!=null){
            result.setProficiency(employee.getProficiency());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getOneEmployee(String employeeEmail) throws EmployeeNotFoundException {
        Optional <Employee> optional = employeeRepository.findById(employeeEmail);
        return optional.isPresent()?optional.get():null ;
    }

    @Override
    public List<Employee> getEmployeeByProficiency(String proficiency) throws EmployeeNotFoundException {
        return employeeRepository.getEmployeeByProficiency(proficiency);
    }
}
