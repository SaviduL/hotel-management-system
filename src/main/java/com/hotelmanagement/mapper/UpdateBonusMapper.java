package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.UpdateBonusDTO;
import com.hotelmanagement.entity.Bonus;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UpdateBonusMapper {
    @Mapping(source = "employeeId", target = "employeeID.id")
    Bonus updateBonusDTOToBonus(UpdateBonusDTO updateBonusDTO);

    @Mapping(source = "employeeID.id", target = "employeeId")
    UpdateBonusDTO bonusToUpdateBonusDTO(Bonus bonus);

    @Mapping(source = "employeeId", target = "employeeID.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Bonus updateBonusFromUpdateBonusDTO(UpdateBonusDTO updateBonusDTO, @MappingTarget Bonus bonus);
}
