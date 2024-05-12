package com.example.EmpManagementSystem.controller;

import com.example.EmpManagementSystem.entity.Employee;
import com.example.EmpManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/";
    }

    /*
    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-details"; // Assuming you have a Thymeleaf template for displaying employee details
    }
    */

    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-details";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/";
    }

    @GetMapping("/employee/details/{id}")
    public String showEmployeeDetails(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-details"; // Assuming you have a Thymeleaf template for displaying employee details
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
