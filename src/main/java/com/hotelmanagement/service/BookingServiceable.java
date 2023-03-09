package com.hotelmanagement.service;

import com.hotelmanagement.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookingServiceable {
    List<ResourceBookingDTO> getAllBookings();

    ResponseEntity<Boolean> createBooking(StoreBookingDTO storeBookingDTO);

    ResourceBookingDTO getBookingByID(Integer id);

    ResponseEntity<Boolean> changeBookingDate(ChangeDateBookingDTO changeDateBookingDTO);

    ResponseEntity<Boolean> changeBookingNoOfPerson(ChangeNoOfPersonBookingDTO changeNoOfPersonBookingDTO);

    ResponseEntity<Boolean> checkInToBooking(ChangeStatusBookingDTO changeStatusBookingDTO);

    ResponseEntity<Boolean> checkOutFromBooking(ChangeStatusBookingDTO changeStatusBookingDTO);

    ResponseEntity<Boolean> cancelBooking(ChangeStatusBookingDTO changeStatusBookingDTO);

    ResponseEntity<Boolean> deleteBooking(Integer id);
}
