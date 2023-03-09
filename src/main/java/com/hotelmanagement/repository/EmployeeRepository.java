package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Procedure(procedureName = "addEmployee")
    void addEmployee(
            String employeeType,
            String title,
            String nic,
            String firstName,
            String lastName,
            LocalDate dob,
            String sex,
            String telNo,
            String address,
            String email,
            BigDecimal salary
    );

    @Procedure(procedureName = "updateEmployee")
    void updateEmployee(
            String id,
            String title,
            String nic,
            String firstName,
            String lastName,
            LocalDate dob,
            String sex,
            String telNo,
            String address,
            String email,
            BigDecimal salary,
            String status
    );

    @Procedure(procedureName = "deleteEmployee")
    void deleteEmployee(String id);

    @Query(
            value = "SELECT * FROM employees_view",
            nativeQuery = true)
    List<Employee> findAll();

    @Query(
            value = "SELECT * FROM employees_view WHERE employeeID = ?1",
            nativeQuery = true)
    Employee getById(String id);
}