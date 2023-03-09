package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Booking} entity
 */
public class StoreBookingDTO implements Serializable {
    @Size(max = 10)
    private String guestId;
    @NotNull
    private LocalDate dateFrom;
    @NotNull
    private LocalDate dateTo;
    @NotNull
    private Integer noOfPerson;
    @Size(max = 8)
    private String receptionistId;
    private Set<StoreReservationDTO> reservations = new LinkedHashSet<>();

    public StoreBookingDTO() {
    }

    public StoreBookingDTO(String guestId, LocalDate dateFrom, LocalDate dateTo, Integer noOfPerson, String receptionistId, Set<StoreReservationDTO> reservations) {
        this.guestId = guestId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.noOfPerson = noOfPerson;
        this.receptionistId = receptionistId;
        this.reservations = reservations;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
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

    public Integer getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public String getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(String receptionistId) {
        this.receptionistId = receptionistId;
    }

    public Set<StoreReservationDTO> getReservations() {
        return reservations;
    }

    public void setReservations(Set<StoreReservationDTO> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreBookingDTO entity = (StoreBookingDTO) o;
        return Objects.equals(this.guestId, entity.guestId) &&
                Objects.equals(this.dateFrom, entity.dateFrom) &&
                Objects.equals(this.dateTo, entity.dateTo) &&
                Objects.equals(this.noOfPerson, entity.noOfPerson) &&
                Objects.equals(this.receptionistId, entity.receptionistId) &&
                Objects.equals(this.reservations, entity.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId, dateFrom, dateTo, noOfPerson, receptionistId, reservations);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "guestId = " + guestId + ", " +
                "dateFrom = " + dateFrom + ", " +
                "dateTo = " + dateTo + ", " +
                "noOfPerson = " + noOfPerson + ", " +
                "receptionistId = " + receptionistId + ", " +
                "reservations = " + reservations + ")";
    }
}