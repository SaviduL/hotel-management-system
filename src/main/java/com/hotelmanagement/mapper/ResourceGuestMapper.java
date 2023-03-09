package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceGuestDTO;
import com.hotelmanagement.entity.Guest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceGuestMapper {
    Guest resourceGuestDTOToGuest(ResourceGuestDTO resourceGuestDTO);

    ResourceGuestDTO guestToResourceGuestDTO(Guest guest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Guest updateGuestFromResourceGuestDTO(ResourceGuestDTO resourceGuestDTO, @MappingTarget Guest guest);
}
