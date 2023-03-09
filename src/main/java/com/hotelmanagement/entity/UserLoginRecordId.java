package com.hotelmanagement.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
public class UserLoginRecordId implements Serializable {
    private static final long serialVersionUID = 6924481909981207742L;
    @Size(max = 8)
    @NotNull
    @Column(name = "userID", nullable = false, length = 8)
    private String userID;

    @NotNull
    @Column(name = "loginDate", nullable = false)
    private LocalDate loginDate;

    @NotNull
    @Column(name = "loginTime", nullable = false)
    private LocalTime loginTime;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public LocalDate getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalDate loginDate) {
        this.loginDate = loginDate;
    }

    public LocalTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalTime loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserLoginRecordId entity = (UserLoginRecordId) o;
        return Objects.equals(this.loginTime, entity.loginTime) &&
                Objects.equals(this.loginDate, entity.loginDate) &&
                Objects.equals(this.userID, entity.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginTime, loginDate, userID);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "serialVersionUID = " + serialVersionUID + ", " +
                "userID = " + userID + ", " +
                "loginDate = " + loginDate + ", " +
                "loginTime = " + loginTime + ")";
    }
}