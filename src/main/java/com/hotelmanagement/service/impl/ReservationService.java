package com.hotelmanagement.service.impl;

import com.hotelmanagement.entity.Reservation;
import com.hotelmanagement.repository.ReservationRepository;
import com.hotelmanagement.service.ReservationServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReservationService implements ReservationServiceable {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ResponseEntity<Boolean> createReservation(Set<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            reservationRepository.addReservation(
                    reservation.getId().getBookingID(),
                    reservation.getId().getRoomID(),
                    reservation.getNett()
            );
        }

        return ResponseEntity.ok(true);
    }
}
