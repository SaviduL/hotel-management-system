package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.UpdateAdvanceDTO;
import com.hotelmanagement.entity.Advance;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UpdateAdvanceMapper {
    @Mapping(source = "employeeId", target = "employeeID.id")
    @Mapping(source = "handlerManagerId", target = "handlerManagerID.id")
    Advance updateAdvanceDTOToAdvance(UpdateAdvanceDTO updateAdvanceDTO);

    @InheritInverseConfiguration(name = "updateAdvanceDTOToAdvance")
    UpdateAdvanceDTO advanceToUpdateAdvanceDTO(Advance advance);

    @InheritConfiguration(name = "updateAdvanceDTOToAdvance")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Advance updateAdvanceFromUpdateAdvanceDTO(UpdateAdvanceDTO updateAdvanceDTO, @MappingTarget Advance advance);
}
