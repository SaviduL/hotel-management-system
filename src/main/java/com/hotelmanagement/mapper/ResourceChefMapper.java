package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceChefDTO;
import com.hotelmanagement.entity.Chef;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceChefMapper {
    @Mapping(source = "employee", target = "employees")
    Chef resourceChefDTOToChef(ResourceChefDTO resourceChefDTO);

    @Mapping(source = "employees", target = "employee")
    ResourceChefDTO chefToResourceChefDTO(Chef chef);

    @Mapping(source = "employee", target = "employees")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chef updateChefFromResourceChefDTO(ResourceChefDTO resourceChefDTO, @MappingTarget Chef chef);
}
