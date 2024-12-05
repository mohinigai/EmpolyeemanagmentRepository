package com.clover.service;

import com.clover.model.Employee;
import com.clover.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmpolyee(Employee empolyee) {
        Employee createEmpolyee = employeeRepository.save(empolyee);
        return createEmpolyee;
    }

    public Map<String, Long> getGenderCount() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }


    public Set<String> getDepartments() {
        return employeeRepository.findAll().stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
    }


    public Map<String, Double> getAverageAgeByGender() {
        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.averagingInt(Employee::getAge)));
    }


    public Employee getHighestPaidEmployee() {
        return employeeRepository.findAll().stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("No employees found"));
    }


    public List<Employee> getEmployeesJoinedAfter2015() {
        return employeeRepository.findByYearOfJoiningAfter(2015);
    }


    public Map<String, Long> getEmployeeCountByDepartment() {
        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }


    public Map<String, Double> getAverageSalaryByDepartment() {
        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }


    public Optional<Employee> getYoungestMaleInProductDevelopment() {
        return employeeRepository.findAll().stream()
                .filter(e -> e.getGender().equals("Male") && e.getDepartment().equals("Product Development"))
                .min(Comparator.comparingInt(Employee::getAge));
    }


    public Employee getEmployeeWithMostExperience() {
        return employeeRepository.findAll().stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining))
                .orElseThrow(() -> new RuntimeException("No employees found"));
    }


    public Map<String, Long> getGenderCountInSalesAndMarketing() {
        return employeeRepository.findAll().stream()
                .filter(e -> e.getDepartment().equals("Sales and Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }


    public Map<String, Double> getAverageSalaryByGender() {
        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.averagingDouble(Employee::getSalary)));
    }


    public Map<String, List<String>> getEmployeeNamesByDepartment() {
        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
    }


    public Map<String, Double> getAverageAndTotalSalary() {
        List<Employee> employees = employeeRepository.findAll();
        double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        Map<String, Double> result = new HashMap<>();
        result.put("totalSalary", totalSalary);
        result.put("averageSalary", averageSalary);
        return result;
    }

    public Employee getOldestEmployee() {
        return employeeRepository.findAll().stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElseThrow(() -> new RuntimeException("No employees found"));
    }
}