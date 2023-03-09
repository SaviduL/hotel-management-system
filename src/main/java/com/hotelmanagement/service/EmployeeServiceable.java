package com.hotelmanagement.service;

import com.hotelmanagement.dto.ResourceEmployeeDTO;
import com.hotelmanagement.dto.StoreEmployeeDTO;
import com.hotelmanagement.dto.UpdateEmployeeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeServiceable {
    List<ResourceEmployeeDTO> getAllEmployees();

    ResponseEntity<Boolean> createEmployee(StoreEmployeeDTO storeEmployeeDTO);

    ResourceEmployeeDTO getEmployeeByID(String id);

    ResponseEntity<Boolean> updateEmployee(UpdateEmployeeDTO updateEmployeeDTO);

    ResponseEntity<Boolean> deleteEmployee(String id);
}
