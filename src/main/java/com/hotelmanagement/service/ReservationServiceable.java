package com.hotelmanagement.service;

import com.hotelmanagement.entity.Reservation;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface ReservationServiceable {
    ResponseEntity<Boolean> createReservation(Set<Reservation> reservations);
}
