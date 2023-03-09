package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceEmployeeDTO;
import com.hotelmanagement.entity.Employee;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceEmployeeMapper {
    Employee resourceEmployeeDTOToEmployee(ResourceEmployeeDTO resourceEmployeeDTO);

    ResourceEmployeeDTO employeeToResourceEmployeeDTO(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee updateEmployeeFromResourceEmployeeDTO(ResourceEmployeeDTO resourceEmployeeDTO, @MappingTarget Employee employee);
}
