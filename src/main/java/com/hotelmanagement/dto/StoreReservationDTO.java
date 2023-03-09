package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Reservation} entity
 */
public class StoreReservationDTO implements Serializable {
    @NotNull
    private Integer reservationBookingID;
    @NotNull
    private Integer reservationRoomID;
    @NotNull
    private BigDecimal nett;

    public StoreReservationDTO() {
    }

    public StoreReservationDTO(Integer reservationBookingID, Integer reservationRoomID, BigDecimal nett) {
        this.reservationBookingID = reservationBookingID;
        this.reservationRoomID = reservationRoomID;
        this.nett = nett;
    }

    public Integer getReservationBookingID() {
        return reservationBookingID;
    }

    public void setReservationBookingID(Integer reservationBookingID) {
        this.reservationBookingID = reservationBookingID;
    }

    public Integer getReservationRoomID() {
        return reservationRoomID;
    }

    public void setReservationRoomID(Integer reservationRoomID) {
        this.reservationRoomID = reservationRoomID;
    }

    public BigDecimal getNett() {
        return nett;
    }

    public void setNett(BigDecimal nett) {
        this.nett = nett;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreReservationDTO entity = (StoreReservationDTO) o;
        return Objects.equals(this.reservationBookingID, entity.reservationBookingID) &&
                Objects.equals(this.reservationRoomID, entity.reservationRoomID) &&
                Objects.equals(this.nett, entity.nett);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationBookingID, reservationRoomID, nett);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "reservationBookingID = " + reservationBookingID + ", " +
                "reservationRoomID = " + reservationRoomID + ", " +
                "nett = " + nett + ")";
    }
}