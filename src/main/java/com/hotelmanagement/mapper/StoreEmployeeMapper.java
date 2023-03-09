package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.StoreEmployeeDTO;
import com.hotelmanagement.entity.Employee;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreEmployeeMapper {
    Employee storeEmployeeDTOToEmployee(StoreEmployeeDTO storeEmployeeDTO);

    StoreEmployeeDTO employeeToStoreEmployeeDTO(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee updateEmployeeFromStoreEmployeeDTO(StoreEmployeeDTO storeEmployeeDTO, @MappingTarget Employee employee);
}
