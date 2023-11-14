package com.SpringMVCCRUD.Employee.Service;

import com.SpringMVCCRUD.Employee.Entity.Employee;
import com.SpringMVCCRUD.Employee.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();

        return allEmployees;
    }

    public void addEmployee(Employee newEmployee) {
        employeeRepository.save(newEmployee);
    }

    public void updateEmployee(Employee employeeToUpdate) {
        employeeRepository.save(employeeToUpdate);
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
