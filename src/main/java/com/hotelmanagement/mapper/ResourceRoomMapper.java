package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceRoomDTO;
import com.hotelmanagement.entity.Room;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceRoomMapper {
    Room resourceRoomDTOToRoom(ResourceRoomDTO resourceRoomDTO);

    ResourceRoomDTO roomToResourceRoomDTO(Room room);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Room updateRoomFromResourceRoomDTO(ResourceRoomDTO resourceRoomDTO, @MappingTarget Room room);
}
