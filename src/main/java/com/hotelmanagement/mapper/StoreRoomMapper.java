package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.StoreRoomDTO;
import com.hotelmanagement.entity.Room;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreRoomMapper {
    Room storeRoomDTOToRoom(StoreRoomDTO storeRoomDTO);

    StoreRoomDTO roomToStoreRoomDTO(Room room);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Room updateRoomFromStoreRoomDTO(StoreRoomDTO storeRoomDTO, @MappingTarget Room room);
}
