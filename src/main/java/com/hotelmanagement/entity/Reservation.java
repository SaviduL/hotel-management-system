package com.hotelmanagement.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "reservations", schema = "hotel_springboot_db", indexes = {
        @Index(name = "roomID", columnList = "roomID")
})
public class Reservation {
    @EmbeddedId
    private ReservationId id;

    @MapsId("bookingID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bookingID", nullable = false)
    private Booking bookingID;

    @MapsId("roomID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roomID", nullable = false)
    private Room roomID;

    @NotNull
    @Column(name = "nett", nullable = false, precision = 8, scale = 2)
    private BigDecimal nett;

    @Column(name = "deletedAt")
    private Instant deletedAt;

    public ReservationId getId() {
        return id;
    }

    public void setId(ReservationId id) {
        this.id = id;
    }

    public Booking getBookingID() {
        return bookingID;
    }

    public void setBookingID(Booking bookingID) {
        this.bookingID = bookingID;
    }

    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    public BigDecimal getNett() {
        return nett;
    }

    public void setNett(BigDecimal nett) {
        this.nett = nett;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Reservation that = (Reservation) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "EmbeddedId = " + id + ", " +
                "nett = " + nett + ")";
    }
}