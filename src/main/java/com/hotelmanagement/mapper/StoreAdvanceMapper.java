package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.StoreAdvanceDTO;
import com.hotelmanagement.entity.Advance;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreAdvanceMapper {
    @Mapping(source = "employeeId", target = "employeeID.id")
    @Mapping(source = "handlerManagerId", target = "handlerManagerID.id")
    Advance storeAdvanceDTOToAdvance(StoreAdvanceDTO storeAdvanceDTO);

    @InheritInverseConfiguration(name = "storeAdvanceDTOToAdvance")
    StoreAdvanceDTO advanceToStoreAdvanceDTO(Advance advance);

    @InheritConfiguration(name = "storeAdvanceDTOToAdvance")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Advance updateAdvanceFromStoreAdvanceDTO(StoreAdvanceDTO storeAdvanceDTO, @MappingTarget Advance advance);
}
