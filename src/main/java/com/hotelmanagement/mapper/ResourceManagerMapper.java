package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceManagerDTO;
import com.hotelmanagement.entity.Manager;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceManagerMapper {
    @Mapping(source = "employee", target = "employees")
    Manager resourceManagerDTOToManager(ResourceManagerDTO resourceManagerDTO);

    @Mapping(source = "employees", target = "employee")
    ResourceManagerDTO managerToResourceManagerDTO(Manager manager);

    @Mapping(source = "employee", target = "employees")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Manager updateManagerFromResourceManagerDTO(ResourceManagerDTO resourceManagerDTO, @MappingTarget Manager manager);
}
