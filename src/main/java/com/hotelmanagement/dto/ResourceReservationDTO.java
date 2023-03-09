package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Reservation} entity
 */
public class ResourceReservationDTO implements Serializable {
    private Integer bookingId;
    private ResourceRoomDTO room;
    @NotNull
    private BigDecimal nett;

    public ResourceReservationDTO() {
    }

    public ResourceReservationDTO(Integer bookingId, ResourceRoomDTO room, BigDecimal nett) {
        this.bookingId = bookingId;
        this.room = room;
        this.nett = nett;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public ResourceRoomDTO getRoom() {
        return room;
    }

    public void setRoom(ResourceRoomDTO room) {
        this.room = room;
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
        ResourceReservationDTO entity = (ResourceReservationDTO) o;
        return Objects.equals(this.bookingId, entity.bookingId) &&
                Objects.equals(this.room, entity.room) &&
                Objects.equals(this.nett, entity.nett);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, room, nett);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "bookingId = " + bookingId + ", " +
                "room = " + room + ", " +
                "nett = " + nett + ")";
    }
}