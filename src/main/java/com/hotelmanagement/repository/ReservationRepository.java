package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Reservation;
import com.hotelmanagement.entity.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
    @Procedure(procedureName = "addReservation")
    void addReservation(Integer bookingID, Integer roomID, BigDecimal nett);
}