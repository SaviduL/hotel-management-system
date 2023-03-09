package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ChangeStatusBookingDTO;
import com.hotelmanagement.entity.Booking;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChangeStatusBookingMapper {
    @Mapping(source = "receptionistId", target = "receptionistID.id")
    Booking changeStatusBookingDTOToBooking(ChangeStatusBookingDTO changeStatusBookingDTO);

    @Mapping(source = "receptionistID.id", target = "receptionistId")
    ChangeStatusBookingDTO bookingToChangeStatusBookingDTO(Booking booking);

    @Mapping(source = "receptionistId", target = "receptionistID.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Booking updateBookingFromChangeStatusBookingDTO(ChangeStatusBookingDTO changeStatusBookingDTO, @MappingTarget Booking booking);
}
