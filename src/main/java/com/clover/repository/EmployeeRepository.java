package com.clover.repository;

import com.clover.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByGender(String gender);
    List<Employee> findByDepartment(String department);
    List<Employee> findByYearOfJoiningAfter(int year);
}



