package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.UpdateRoomDTO;
import com.hotelmanagement.entity.Room;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UpdateRoomMapper {
    Room updateRoomDTOToRoom(UpdateRoomDTO updateRoomDTO);

    UpdateRoomDTO roomToUpdateRoomDTO(Room room);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Room updateRoomFromUpdateRoomDTO(UpdateRoomDTO updateRoomDTO, @MappingTarget Room room);
}
