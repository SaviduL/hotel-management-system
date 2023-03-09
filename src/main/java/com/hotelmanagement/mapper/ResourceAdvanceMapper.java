package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceAdvanceDTO;
import com.hotelmanagement.entity.Advance;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceAdvanceMapper {
    @Mapping(source = "employee", target = "employeeID")
    @Mapping(source = "handlerManager", target = "handlerManagerID")
    Advance resourceAdvanceDTOToAdvance(ResourceAdvanceDTO resourceAdvanceDTO);

    @InheritInverseConfiguration(name = "resourceAdvanceDTOToAdvance")
    ResourceAdvanceDTO advanceToResourceAdvanceDTO(Advance advance);

    @InheritConfiguration(name = "resourceAdvanceDTOToAdvance")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Advance updateAdvanceFromResourceAdvanceDTO(ResourceAdvanceDTO resourceAdvanceDTO, @MappingTarget Advance advance);
}
