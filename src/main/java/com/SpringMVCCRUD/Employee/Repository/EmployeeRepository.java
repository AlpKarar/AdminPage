package com.SpringMVCCRUD.Employee.Repository;

import com.SpringMVCCRUD.Employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
