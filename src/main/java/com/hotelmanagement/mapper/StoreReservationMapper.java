package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.StoreReservationDTO;
import com.hotelmanagement.entity.Reservation;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreReservationMapper {
    @Mapping(source = "reservationBookingID", target = "id.bookingID")
    @Mapping(source = "reservationRoomID", target = "id.roomID")
    Reservation storeReservationDTOToReservation(StoreReservationDTO storeReservationDTO);

    @InheritInverseConfiguration(name = "storeReservationDTOToReservation")
    StoreReservationDTO reservationToStoreReservationDTO(Reservation reservation);

    @InheritConfiguration(name = "storeReservationDTOToReservation")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reservation updateReservationFromStoreReservationDTO(StoreReservationDTO storeReservationDTO, @MappingTarget Reservation reservation);
}
