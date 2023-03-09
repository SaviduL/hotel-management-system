package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ChangeNoOfPersonBookingDTO;
import com.hotelmanagement.entity.Booking;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChangeNoOfPersonBookingMapper {
    @Mapping(source = "receptionistId", target = "receptionistID.id")
    Booking changeNoOfPersonBookingDTOToBooking(ChangeNoOfPersonBookingDTO changeNoOfPersonBookingDTO);

    @Mapping(source = "receptionistID.id", target = "receptionistId")
    ChangeNoOfPersonBookingDTO bookingToChangeNoOfPersonBookingDTO(Booking booking);

    @Mapping(source = "receptionistId", target = "receptionistID.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Booking updateBookingFromChangeNoOfPersonBookingDTO(ChangeNoOfPersonBookingDTO changeNoOfPersonBookingDTO, @MappingTarget Booking booking);
}
