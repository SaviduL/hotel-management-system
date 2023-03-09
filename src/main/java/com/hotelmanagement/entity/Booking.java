package com.hotelmanagement.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bookings", schema = "hotel_springboot_db", indexes = {
        @Index(name = "guestID", columnList = "guestID"),
        @Index(name = "receptionistID", columnList = "receptionistID")
})
public class Booking {
    @Id
    @Column(name = "bookingID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "guestID", nullable = false)
    private Guest guestID;

    @NotNull
    @Column(name = "dateFrom", nullable = false)
    private LocalDate dateFrom;

    @NotNull
    @Column(name = "dateTo", nullable = false)
    private LocalDate dateTo;

    @Size(max = 9)
    @NotNull
    @Column(name = "status", nullable = false, length = 9)
    private String status;

    @Column(name = "billingAmount", precision = 8, scale = 2)
    private BigDecimal billingAmount;

    @NotNull
    @Column(name = "noOfPerson", nullable = false)
    private Integer noOfPerson;

    @Column(name = "checkIn")
    private Instant checkIn;

    @Column(name = "checkOut")
    private Instant checkOut;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receptionistID", nullable = false)
    private Receptionist receptionistID;

    @Column(name = "deletedAt")
    private Instant deletedAt;

    @OneToMany(mappedBy = "bookingID")
    private Set<Reservation> reservations = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Guest getGuestID() {
        return guestID;
    }

    public void setGuestID(Guest guestID) {
        this.guestID = guestID;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(BigDecimal billingAmount) {
        this.billingAmount = billingAmount;
    }

    public Integer getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public Instant getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Instant checkIn) {
        this.checkIn = checkIn;
    }

    public Instant getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Instant checkOut) {
        this.checkOut = checkOut;
    }

    public Receptionist getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(Receptionist receptionistID) {
        this.receptionistID = receptionistID;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Booking booking = (Booking) o;
        return id != null && Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "dateFrom = " + dateFrom + ", " +
                "dateTo = " + dateTo + ", " +
                "status = " + status + ", " +
                "billingAmount = " + billingAmount + ", " +
                "noOfPerson = " + noOfPerson + ", " +
                "checkIn = " + checkIn + ", " +
                "checkOut = " + checkOut + ")";
    }
}