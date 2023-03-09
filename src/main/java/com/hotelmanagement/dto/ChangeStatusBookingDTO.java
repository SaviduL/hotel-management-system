package com.hotelmanagement.dto;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Booking} entity
 */
public class ChangeStatusBookingDTO implements Serializable {
    private Integer id;
    @Size(max = 8)
    private String receptionistId;

    public ChangeStatusBookingDTO() {
    }

    public ChangeStatusBookingDTO(Integer id, String receptionistId) {
        this.id = id;
        this.receptionistId = receptionistId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        ChangeStatusBookingDTO entity = (ChangeStatusBookingDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.receptionistId, entity.receptionistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, receptionistId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "receptionistId = " + receptionistId + ")";
    }
}