package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Room} entity
 */
public class StoreRoomDTO implements Serializable {
    @Size(max = 50)
    @NotNull
    private String name;
    @NotNull
    private Integer roomNo;
    @Size(max = 100)
    private String description;
    @Size(max = 15)
    @NotNull
    private String bedType;
    @NotNull
    private Integer noOfBed;
    @Size(max = 10)
    @NotNull
    private String roomType;
    @NotNull
    private BigDecimal charge;

    public StoreRoomDTO() {
    }

    public StoreRoomDTO(String name, Integer roomNo, String description, String bedType, Integer noOfBed, String roomType, BigDecimal charge) {
        this.name = name;
        this.roomNo = roomNo;
        this.description = description;
        this.bedType = bedType;
        this.noOfBed = noOfBed;
        this.roomType = roomType;
        this.charge = charge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public Integer getNoOfBed() {
        return noOfBed;
    }

    public void setNoOfBed(Integer noOfBed) {
        this.noOfBed = noOfBed;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreRoomDTO entity = (StoreRoomDTO) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.roomNo, entity.roomNo) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.bedType, entity.bedType) &&
                Objects.equals(this.noOfBed, entity.noOfBed) &&
                Objects.equals(this.roomType, entity.roomType) &&
                Objects.equals(this.charge, entity.charge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roomNo, description, bedType, noOfBed, roomType, charge);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "roomNo = " + roomNo + ", " +
                "description = " + description + ", " +
                "bedType = " + bedType + ", " +
                "noOfBed = " + noOfBed + ", " +
                "roomType = " + roomType + ", " +
                "charge = " + charge + ")";
    }
}