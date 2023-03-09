package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Guest} entity
 */
public class UpdateGuestDTO implements Serializable {
    @Size(max = 10)
    private String id;
    @Size(max = 5)
    @NotNull
    private String title;
    @Size(max = 12)
    @NotNull
    private String nic;
    @Size(max = 50)
    @NotNull
    private String firstName;
    @Size(max = 50)
    private String lastName;
    @Size(max = 6)
    @NotNull
    private String sex;
    @Size(max = 150)
    @NotNull
    private String address;
    @Size(max = 50)
    private String email;

    public UpdateGuestDTO() {
    }

    public UpdateGuestDTO(String id, String title, String nic, String firstName, String lastName, String sex, String address, String email) {
        this.id = id;
        this.title = title;
        this.nic = nic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.address = address;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateGuestDTO entity = (UpdateGuestDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.nic, entity.nic) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.sex, entity.sex) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.email, entity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, nic, firstName, lastName, sex, address, email);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "nic = " + nic + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "sex = " + sex + ", " +
                "address = " + address + ", " +
                "email = " + email + ")";
    }
}