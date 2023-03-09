package com.hotelmanagement.controller;

import com.hotelmanagement.dto.*;
import com.hotelmanagement.service.BookingServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1.0/bookings")
public class BookingController {
    @Autowired
    private BookingServiceable bookingServiceable;

    @GetMapping()
    public ResponseEntity<List<ResourceBookingDTO>> index() {
        return ResponseEntity.ok(bookingServiceable.getAllBookings());
    }

    @PostMapping()
    public ResponseEntity<Boolean> store(@RequestBody StoreBookingDTO storeBookingDTO) {
        return bookingServiceable.createBooking(storeBookingDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceBookingDTO> show(@PathVariable Integer id) {
        return ResponseEntity.ok(bookingServiceable.getBookingByID(id));
    }

    @PutMapping("/changeBookingDate/{id}")
    public ResponseEntity<Boolean> changeBookingDate(@PathVariable Integer id, @RequestBody ChangeDateBookingDTO changeDateBookingDTO) {
        changeDateBookingDTO.setId(id);
        return bookingServiceable.changeBookingDate(changeDateBookingDTO);
    }

    @PutMapping("/changeBookingNoOfPerson/{id}")
    public ResponseEntity<Boolean> changeBookingNoOfPerson(@PathVariable Integer id, @RequestBody ChangeNoOfPersonBookingDTO changeNoOfPersonBookingDTO) {
        changeNoOfPersonBookingDTO.setId(id);
        return bookingServiceable.changeBookingNoOfPerson(changeNoOfPersonBookingDTO);
    }

    @PutMapping("/checkInToBooking/{id}")
    public ResponseEntity<Boolean> checkInToBooking(@PathVariable Integer id, @RequestBody ChangeStatusBookingDTO changeStatusBookingDTO) {
        changeStatusBookingDTO.setId(id);
        return bookingServiceable.checkInToBooking(changeStatusBookingDTO);
    }

    @PutMapping("/checkOutFromBooking/{id}")
    public ResponseEntity<Boolean> checkOutFromBooking(@PathVariable Integer id, @RequestBody ChangeStatusBookingDTO changeStatusBookingDTO) {
        changeStatusBookingDTO.setId(id);
        return bookingServiceable.checkOutFromBooking(changeStatusBookingDTO);
    }

    @PutMapping("/cancelBooking/{id}")
    public ResponseEntity<Boolean> cancelBooking(@PathVariable Integer id, @RequestBody ChangeStatusBookingDTO changeStatusBookingDTO) {
        changeStatusBookingDTO.setId(id);
        return bookingServiceable.cancelBooking(changeStatusBookingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Integer id) {
        return bookingServiceable.deleteBooking(id);
    }
}
