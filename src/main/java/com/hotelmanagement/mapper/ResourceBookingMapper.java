package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceBookingDTO;
import com.hotelmanagement.entity.Booking;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceBookingMapper {
    @Mapping(source = "guest", target = "guestID")
    @Mapping(source = "receptionistId", target = "receptionistID.id")
    @Mapping(source = "receptionistEmployee", target = "receptionistID.employees")
    Booking resourceBookingDTOToBooking(ResourceBookingDTO resourceBookingDTO);

    @InheritInverseConfiguration(name = "resourceBookingDTOToBooking")
    ResourceBookingDTO bookingToResourceBookingDTO(Booking booking);

    @InheritConfiguration(name = "resourceBookingDTOToBooking")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Booking updateBookingFromResourceBookingDTO(ResourceBookingDTO resourceBookingDTO, @MappingTarget Booking booking);

    @AfterMapping
    default void linkReservations(@MappingTarget Booking booking) {
        booking.getReservations().forEach(reservation -> reservation.setBookingID(booking));
    }
}
