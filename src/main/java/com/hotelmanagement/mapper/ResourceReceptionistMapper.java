package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceReceptionistDTO;
import com.hotelmanagement.entity.Receptionist;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceReceptionistMapper {
    @Mapping(source = "employee", target = "employees")
    Receptionist resourceReceptionistDTOToReceptionist(ResourceReceptionistDTO resourceReceptionistDTO);

    @Mapping(source = "employees", target = "employee")
    ResourceReceptionistDTO receptionistToResourceReceptionistDTO(Receptionist receptionist);

    @Mapping(source = "employee", target = "employees")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Receptionist updateReceptionistFromResourceReceptionistDTO(ResourceReceptionistDTO resourceReceptionistDTO, @MappingTarget Receptionist receptionist);
}
