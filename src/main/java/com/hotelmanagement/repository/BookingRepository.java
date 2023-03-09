package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Procedure(procedureName = "addBooking")
    Integer addBooking(
            String guestID,
            LocalDate dateFrom,
            LocalDate dateTo,
            Integer noOfPerson,
            String receptionistID
    );

    @Procedure(procedureName = "changeBookingDate")
    void changeBookingDate(
            Integer id,
            LocalDate dateFrom,
            LocalDate dateTo,
            String receptionistId
    );

    @Procedure(procedureName = "changeBookingNoOfPerson")
    void changeBookingNoOfPerson(
            Integer id,
            Integer noOfPerson,
            String receptionistId
    );

    @Procedure(procedureName = "checkInToBooking")
    void checkInToBooking(
            Integer id,
            String receptionistId
    );

    @Procedure(procedureName = "checkOutFromBooking")
    void checkOutFromBooking(
            Integer id,
            String receptionistId
    );

    @Procedure(procedureName = "cancelBooking")
    void cancelBooking(
            Integer id,
            String receptionistId
    );

    @Procedure(procedureName = "deleteBooking")
    void deleteBooking(Integer id);

    @Query(
            value = "SELECT * FROM bookings_view",
            nativeQuery = true)
    List<Booking> findAll();

    @Query(
            value = "SELECT * FROM bookings_view WHERE bookingID = ?1",
            nativeQuery = true)
    Booking getById(Integer id);
}