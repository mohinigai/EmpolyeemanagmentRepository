package com.clover.controller;

import com.clover.model.Employee;
import com.clover.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class EmpolyeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmpolyee(@RequestBody Employee employee) {
        Employee Employee1 = employeeService.createEmpolyee(employee);
        return new ResponseEntity<Employee>(Employee1, HttpStatus.CREATED);
    }

    // Query 3.1: Count male and female employees
    @GetMapping("/genderCount")
    public ResponseEntity<Map<String, Long>> GenderCount() {
        return ResponseEntity.ok(employeeService.getGenderCount());
    }

    // Query 3.2: Print names of all departments
    @GetMapping("/departments")
    public ResponseEntity<Set<String>> Departments() {
        return ResponseEntity.ok(employeeService.getDepartments());
    }

    // Query 3.3: Average age of male and female employees
    @GetMapping("/averageAgeByGender")
    public ResponseEntity<Map<String, Double>> AverageAgeByGender() {
        return ResponseEntity.ok(employeeService.getAverageAgeByGender());
    }

    // Query 3.4: Highest paid employee
    @GetMapping("/highestPaid")
    public ResponseEntity<Employee> HighestPaidEmployee() {
        return ResponseEntity.ok(employeeService.getHighestPaidEmployee());
    }

    // Query 3.5: Employees who joined after 2015
    @GetMapping("/joinedAfter2015")
    public ResponseEntity<List<Employee>> getEmployeesJoinedAfter() {
        return ResponseEntity.ok(employeeService.getEmployeesJoinedAfter2015());
    }

    // Query 3.7: Average salary of each department
    @GetMapping("/AverageSalaryByDepartment")
    public ResponseEntity<Map<String, Double>> AverageSalaryByDepartments() {
        return ResponseEntity.ok(employeeService.getAverageSalaryByDepartment());
    }

    // Query 3.6: Count employees in each department
    @GetMapping("/EmployeeCountByDepartment")
    public ResponseEntity<Map<String, Long>> EmployeeCountByDepartment() {
        return ResponseEntity.ok(employeeService.getEmployeeCountByDepartment());
    }

    // Query 3.8: Youngest male employee in product development
    @GetMapping("/YoungestMaleInProductDevelopment")
    public ResponseEntity<Optional<Employee>> YoungestMaleInProductDevelopment() {
        return ResponseEntity.ok(employeeService.getYoungestMaleInProductDevelopment());
    }

    // Query 3.9: Employee with most working experience
    @GetMapping("/EmployeeWithMostExperience")
    public ResponseEntity<Employee> EmployeeWithMostExperience() {
        return ResponseEntity.ok(employeeService.getEmployeeWithMostExperience());
    }

    // Query 3.10: Count male and female employees in Sales and Marketing
    @GetMapping("/GenderCountInSalesAndMarketing")
    public ResponseEntity<Map<String, Long>> GenderCountInSalesAndMarketing() {
        return ResponseEntity.ok(employeeService.getGenderCountInSalesAndMarketing());
    }

    // Query 3.11: Average salary by gender
    @GetMapping("/AverageSalaryByGender")
    public ResponseEntity<Map<String, Double>> AverageSalaryByGender() {
        return ResponseEntity.ok(employeeService.getAverageSalaryByGender());
    }

    // Query 3.12: Names of all employees in each department
    @GetMapping("/EmployeeNamesByDepartment")
    public ResponseEntity<Map<String, List<String>>> EmployeeNamesByDepartment() {
        return ResponseEntity.ok(employeeService.getEmployeeNamesByDepartment());
    }

    // Query 3.13: Average salary and total salary of organization
    @GetMapping("/AverageAndTotalSalary")
    public ResponseEntity<Map<String, Double>> AverageAndTotalSalary() {
        return ResponseEntity.ok(employeeService.getAverageAndTotalSalary());
    }

    // Query 3.15: Oldest employee
    @GetMapping("/OldestEmployee")
    public ResponseEntity<Employee> OldestEmployee() {
        return ResponseEntity.ok(employeeService.getOldestEmployee());
    }

}

