package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.UpdateEmployeeDTO;
import com.hotelmanagement.entity.Employee;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UpdateEmployeeMapper {
    Employee updateEmployeeDTOToEmployee(UpdateEmployeeDTO updateEmployeeDTO);

    UpdateEmployeeDTO employeeToUpdateEmployeeDTO(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee updateEmployeeFromUpdateEmployeeDTO(UpdateEmployeeDTO updateEmployeeDTO, @MappingTarget Employee employee);
}
