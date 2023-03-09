package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceReservationDTO;
import com.hotelmanagement.entity.Reservation;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceReservationMapper {
    @Mapping(source = "bookingId", target = "bookingID.id")
    @Mapping(source = "room", target = "roomID")
    Reservation resourceReservationDTOToReservation(ResourceReservationDTO resourceReservationDTO);

    @InheritInverseConfiguration(name = "resourceReservationDTOToReservation")
    ResourceReservationDTO reservationToResourceReservationDTO(Reservation reservation);

    @InheritConfiguration(name = "resourceReservationDTOToReservation")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reservation updateReservationFromResourceReservationDTO(ResourceReservationDTO resourceReservationDTO, @MappingTarget Reservation reservation);
}
