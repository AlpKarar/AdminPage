package com.SpringMVCCRUD.Employee.Controller;

import com.SpringMVCCRUD.Employee.Entity.Employee;
import com.SpringMVCCRUD.Employee.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TestController {

    private EmployeeService employeeService;

    public TestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();

        return ResponseEntity.ok(allEmployees);
    }
}
