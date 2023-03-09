package com.hotelmanagement.controller;


import com.hotelmanagement.dto.ResourceEmployeeDTO;
import com.hotelmanagement.dto.StoreEmployeeDTO;
import com.hotelmanagement.dto.UpdateEmployeeDTO;
import com.hotelmanagement.service.EmployeeServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1.0/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceable employeeServiceable;

    @GetMapping()
    public ResponseEntity<List<ResourceEmployeeDTO>>  index() {
        return ResponseEntity.ok(employeeServiceable.getAllEmployees());
    }

    @PostMapping()
    public ResponseEntity<Boolean> store(@RequestBody StoreEmployeeDTO storeEmployeeDTO) {
        return employeeServiceable.createEmployee(storeEmployeeDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceEmployeeDTO> show(@PathVariable String id) {
        return ResponseEntity.ok(employeeServiceable.getEmployeeByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable String id, @RequestBody UpdateEmployeeDTO updateEmployeeDTO) {
        updateEmployeeDTO.setId(id);
        return employeeServiceable.updateEmployee(updateEmployeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable String id) {
        return employeeServiceable.deleteEmployee(id);
    }
}
