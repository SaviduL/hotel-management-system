package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceBonusDTO;
import com.hotelmanagement.entity.Bonus;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceBonusMapper {
    @Mapping(source = "employee", target = "employeeID")
    Bonus resourceBonusDTOToBonus(ResourceBonusDTO resourceBonusDTO);

    @Mapping(source = "employeeID", target = "employee")
    ResourceBonusDTO bonusToResourceBonusDTO(Bonus bonus);

    @Mapping(source = "employee", target = "employeeID")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Bonus updateBonusFromResourceBonusDTO(ResourceBonusDTO resourceBonusDTO, @MappingTarget Bonus bonus);
}
