package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ChangeDateBookingDTO;
import com.hotelmanagement.entity.Booking;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChangeDateBookingMapper {
    @Mapping(source = "receptionistId", target = "receptionistID.id")
    Booking changeDateBookingDTOToBooking(ChangeDateBookingDTO changeDateBookingDTO);

    @Mapping(source = "receptionistID.id", target = "receptionistId")
    ChangeDateBookingDTO bookingToChangeDateBookingDTO(Booking booking);

    @Mapping(source = "receptionistId", target = "receptionistID.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Booking updateBookingFromChangeDateBookingDTO(ChangeDateBookingDTO changeDateBookingDTO, @MappingTarget Booking booking);
}
