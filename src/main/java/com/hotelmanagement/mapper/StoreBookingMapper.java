package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.StoreBookingDTO;
import com.hotelmanagement.entity.Booking;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreBookingMapper {
    @Mapping(source = "guestId", target = "guestID.id")
    @Mapping(source = "receptionistId", target = "receptionistID.id")
    Booking storeBookingDTOToBooking(StoreBookingDTO storeBookingDTO);

    @InheritInverseConfiguration(name = "storeBookingDTOToBooking")
    StoreBookingDTO bookingToStoreBookingDTO(Booking booking);

    @InheritConfiguration(name = "storeBookingDTOToBooking")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Booking updateBookingFromStoreBookingDTO(StoreBookingDTO storeBookingDTO, @MappingTarget Booking booking);

    @AfterMapping
    default void linkReservations(@MappingTarget Booking booking) {
        booking.getReservations().forEach(reservation -> reservation.setBookingID(booking));
    }
}
