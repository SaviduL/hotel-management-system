package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Booking} entity
 */
public class ChangeDateBookingDTO implements Serializable {
    private Integer id;
    @NotNull
    private LocalDate dateFrom;
    @NotNull
    private LocalDate dateTo;
    @Size(max = 8)
    private String receptionistId;

    public ChangeDateBookingDTO() {
    }

    public ChangeDateBookingDTO(Integer id, LocalDate dateFrom, LocalDate dateTo, String receptionistId) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.receptionistId = receptionistId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(String receptionistId) {
        this.receptionistId = receptionistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeDateBookingDTO entity = (ChangeDateBookingDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.dateFrom, entity.dateFrom) &&
                Objects.equals(this.dateTo, entity.dateTo) &&
                Objects.equals(this.receptionistId, entity.receptionistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateFrom, dateTo, receptionistId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "dateFrom = " + dateFrom + ", " +
                "dateTo = " + dateTo + ", " +
                "receptionistId = " + receptionistId + ")";
    }
}