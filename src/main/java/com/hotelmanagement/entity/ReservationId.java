package com.hotelmanagement.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservationId implements Serializable {
    private static final long serialVersionUID = -4384625116323312112L;
    @NotNull
    @Column(name = "bookingID", nullable = false)
    private Integer bookingID;

    @NotNull
    @Column(name = "roomID", nullable = false)
    private Integer roomID;

    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReservationId entity = (ReservationId) o;
        return Objects.equals(this.bookingID, entity.bookingID) &&
                Objects.equals(this.roomID, entity.roomID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, roomID);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "serialVersionUID = " + serialVersionUID + ", " +
                "bookingID = " + bookingID + ", " +
                "roomID = " + roomID + ")";
    }
}