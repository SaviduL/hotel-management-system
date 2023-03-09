package com.hotelmanagement.service.impl;


import com.hotelmanagement.dto.ResourceEmployeeDTO;
import com.hotelmanagement.dto.StoreEmployeeDTO;
import com.hotelmanagement.dto.UpdateEmployeeDTO;
import com.hotelmanagement.entity.Employee;
import com.hotelmanagement.mapper.ResourceEmployeeMapper;
import com.hotelmanagement.mapper.StoreEmployeeMapper;
import com.hotelmanagement.mapper.UpdateEmployeeMapper;
import com.hotelmanagement.repository.EmployeeRepository;
import com.hotelmanagement.service.EmployeeServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceable {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private StoreEmployeeMapper storeEmployeeMapper;
    @Autowired
    private UpdateEmployeeMapper updateEmployeeMapper;
    @Autowired
    private ResourceEmployeeMapper resourceEmployeeMapper;

    @Override
    public List<ResourceEmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(resourceEmployeeMapper::employeeToResourceEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Boolean> createEmployee(StoreEmployeeDTO storeEmployeeDTO) {
        Employee employee = storeEmployeeMapper.storeEmployeeDTOToEmployee(storeEmployeeDTO);
        employeeRepository.addEmployee(
                employee.getEmployeeType(),
                employee.getTitle(),
                employee.getNic(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDob(),
                employee.getSex(),
                employee.getTelNo(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getSalary()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResourceEmployeeDTO getEmployeeByID(String id) {
        return resourceEmployeeMapper.employeeToResourceEmployeeDTO(employeeRepository.getById(id));
    }

    @Override
    public ResponseEntity<Boolean> updateEmployee(UpdateEmployeeDTO updateEmployeeDTO) {
        Employee employee = updateEmployeeMapper.updateEmployeeDTOToEmployee(updateEmployeeDTO);
        employeeRepository.updateEmployee(
                employee.getId(),
                employee.getTitle(),
                employee.getNic(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDob(),
                employee.getSex(),
                employee.getTelNo(),
                employee.getAddress(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getStatus()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> deleteEmployee(String id) {
        employeeRepository.deleteEmployee(id);
        return ResponseEntity.ok(true);
    }
}
