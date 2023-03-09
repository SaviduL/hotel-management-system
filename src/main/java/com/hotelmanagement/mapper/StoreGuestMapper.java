package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.StoreGuestDTO;
import com.hotelmanagement.entity.Guest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreGuestMapper {
    Guest storeGuestDTOToGuest(StoreGuestDTO storeGuestDTO);

    StoreGuestDTO guestToStoreGuestDTO(Guest guest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Guest updateGuestFromStoreGuestDTO(StoreGuestDTO storeGuestDTO, @MappingTarget Guest guest);
}
