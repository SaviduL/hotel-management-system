package com.hotelmanagement.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "rooms", schema = "hotel_springboot_db")
public class Room {
    @Id
    @Column(name = "roomID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @Column(name = "roomNo", nullable = false)
    private Integer roomNo;

    @Size(max = 100)
    @Column(name = "description", length = 100)
    private String description;

    @Size(max = 15)
    @NotNull
    @Column(name = "bedType", nullable = false, length = 15)
    private String bedType;

    @NotNull
    @Column(name = "noOfBed", nullable = false)
    private Integer noOfBed;

    @Size(max = 10)
    @NotNull
    @Column(name = "roomType", nullable = false, length = 10)
    private String roomType;

    @NotNull
    @Column(name = "charge", nullable = false, precision = 7, scale = 2)
    private BigDecimal charge;

    @Column(name = "deletedAt")
    private Instant deletedAt;

    @OneToMany(mappedBy = "roomID")
    private Set<Reservation> reservations = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        Room room = (Room) o;
        return id != null && Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "roomNo = " + roomNo + ", " +
                "description = " + description + ", " +
                "bedType = " + bedType + ", " +
                "noOfBed = " + noOfBed + ", " +
                "roomType = " + roomType + ", " +
                "charge = " + charge + ")";
    }
}