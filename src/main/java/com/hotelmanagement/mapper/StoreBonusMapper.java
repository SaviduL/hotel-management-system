package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.StoreBonusDTO;
import com.hotelmanagement.entity.Bonus;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreBonusMapper {
    @Mapping(source = "employeeId", target = "employeeID.id")
    Bonus storeBonusDTOToBonus(StoreBonusDTO storeBonusDTO);

    @Mapping(source = "employeeID.id", target = "employeeId")
    StoreBonusDTO bonusToStoreBonusDTO(Bonus bonus);

    @Mapping(source = "employeeId", target = "employeeID.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Bonus updateBonusFromStoreBonusDTO(StoreBonusDTO storeBonusDTO, @MappingTarget Bonus bonus);
}
