package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Booking} entity
 */
public class ChangeNoOfPersonBookingDTO implements Serializable {
    private Integer id;
    @NotNull
    private Integer noOfPerson;
    @Size(max = 8)
    private String receptionistId;

    public ChangeNoOfPersonBookingDTO() {
    }

    public ChangeNoOfPersonBookingDTO(Integer id, Integer noOfPerson, String receptionistId) {
        this.id = id;
        this.noOfPerson = noOfPerson;
        this.receptionistId = receptionistId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeNoOfPersonBookingDTO entity = (ChangeNoOfPersonBookingDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.noOfPerson, entity.noOfPerson) &&
                Objects.equals(this.receptionistId, entity.receptionistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noOfPerson, receptionistId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "noOfPerson = " + noOfPerson + ", " +
                "receptionistId = " + receptionistId + ")";
    }
}