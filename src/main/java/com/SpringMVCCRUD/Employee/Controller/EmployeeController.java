package com.SpringMVCCRUD.Employee.Controller;

import com.SpringMVCCRUD.Employee.Dto.EmployeeDto;
import com.SpringMVCCRUD.Employee.Entity.Employee;
import com.SpringMVCCRUD.Employee.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    private int updatedEmployeeId;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/adminPage")
    public String showAdminPage(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();

        model.addAttribute("employees", allEmployees);

        return "adminPage";
    }

    @GetMapping("/showAddEmployeePage")
    public String showAddEmployeePage(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "addEmployeePage";
    }

    @PostMapping("/addEmployee")
    public ModelAndView addEmployee(@ModelAttribute("employee") EmployeeDto employee, ModelMap modelMap) {
        employeeService.addEmployee(new Employee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        ));

        return new ModelAndView("redirect:/employee/adminPage", modelMap);
    }

    @GetMapping("/updateEmployeePage/{id}")
    public String showUpdateEmployeePage(@PathVariable("id") int id, Model model) {
        updatedEmployeeId = id;

        model.addAttribute("employee", new EmployeeDto());

        return "updateEmployeePage";
    }

    @PostMapping("/updateEmployee")
    public ModelAndView updateEmployee(@ModelAttribute("employee")EmployeeDto employee,
                                       ModelMap modelMap) {

        Employee employeeToUpdate = new Employee(
                updatedEmployeeId,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );

        employeeService.updateEmployee(employeeToUpdate);

        return new ModelAndView("redirect:/employee/adminPage", modelMap);
    }

    @PostMapping("deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") int id, ModelMap modelMap) {
        employeeService.deleteEmployeeById(id);

        return new ModelAndView("redirect:/employee/adminPage", modelMap);
    }
}
