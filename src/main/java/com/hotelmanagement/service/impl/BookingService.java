package com.hotelmanagement.service.impl;

import com.hotelmanagement.dto.*;
import com.hotelmanagement.entity.Booking;
import com.hotelmanagement.entity.Reservation;
import com.hotelmanagement.entity.ReservationId;
import com.hotelmanagement.mapper.*;
import com.hotelmanagement.repository.BookingRepository;
import com.hotelmanagement.service.BookingServiceable;
import com.hotelmanagement.service.ReservationServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingService implements BookingServiceable {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ReservationServiceable reservationServiceable;
    @Autowired
    private StoreBookingMapper storeBookingMapper;
    @Autowired
    private ChangeDateBookingMapper changeDateBookingMapper;
    @Autowired
    private ChangeNoOfPersonBookingMapper changeNoOfPersonBookingMapper;
    @Autowired
    private ChangeStatusBookingMapper changeStatusBookingMapper;
    @Autowired
    private ResourceBookingMapper resourceBookingMapper;

    @Override
    public List<ResourceBookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(resourceBookingMapper::bookingToResourceBookingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Boolean> createBooking(StoreBookingDTO storeBookingDTO) {
        Booking booking = storeBookingMapper.storeBookingDTOToBooking(storeBookingDTO);
        Integer bookingID = bookingRepository.addBooking(
                booking.getGuestID().getId(),
                booking.getDateFrom(),
                booking.getDateTo(),
                booking.getNoOfPerson(),
                booking.getReceptionistID().getId()
        );

        Set<Reservation> reservations = new LinkedHashSet<>();

        for (StoreReservationDTO storeReservationDTO : storeBookingDTO.getReservations()) {
            Reservation reservation = new Reservation();
            reservation.setId(new ReservationId());
            reservation.getId().setBookingID(bookingID);
            reservation.getId().setRoomID(storeReservationDTO.getReservationRoomID());
            reservation.setNett(storeReservationDTO.getNett());

            reservations.add(reservation);
        }

        return reservationServiceable.createReservation(reservations);
    }

    @Override
    public ResourceBookingDTO getBookingByID(Integer id) {
        return resourceBookingMapper.bookingToResourceBookingDTO(bookingRepository.getById(id));
    }

    @Override
    public ResponseEntity<Boolean> changeBookingDate(ChangeDateBookingDTO changeDateBookingDTO) {
        Booking booking = changeDateBookingMapper.changeDateBookingDTOToBooking(changeDateBookingDTO);
        bookingRepository.changeBookingDate(
                booking.getId(),
                booking.getDateFrom(),
                booking.getDateTo(),
                booking.getReceptionistID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> changeBookingNoOfPerson(ChangeNoOfPersonBookingDTO changeNoOfPersonBookingDTO) {
        Booking booking = changeNoOfPersonBookingMapper.changeNoOfPersonBookingDTOToBooking(changeNoOfPersonBookingDTO);
        bookingRepository.changeBookingNoOfPerson(
                booking.getId(),
                booking.getNoOfPerson(),
                booking.getReceptionistID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> checkInToBooking(ChangeStatusBookingDTO changeStatusBookingDTO) {
        Booking booking = changeStatusBookingMapper.changeStatusBookingDTOToBooking(changeStatusBookingDTO);
        bookingRepository.checkInToBooking(
                booking.getId(),
                booking.getReceptionistID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> checkOutFromBooking(ChangeStatusBookingDTO changeStatusBookingDTO) {
        Booking booking = changeStatusBookingMapper.changeStatusBookingDTOToBooking(changeStatusBookingDTO);
        bookingRepository.checkOutFromBooking(
                booking.getId(),
                booking.getReceptionistID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> cancelBooking(ChangeStatusBookingDTO changeStatusBookingDTO) {
        Booking booking = changeStatusBookingMapper.changeStatusBookingDTOToBooking(changeStatusBookingDTO);
        bookingRepository.cancelBooking(
                booking.getId(),
                booking.getReceptionistID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> deleteBooking(Integer id) {
        bookingRepository.deleteBooking(id);
        return ResponseEntity.ok(true);
    }
}
