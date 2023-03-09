package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.User} entity
 */
public class ResourceUserDTO implements Serializable {
    @Size(max = 8)
    private String id;
    @Size(max = 30)
    @NotNull
    private String username;
    @Size(max = 10)
    @NotNull
    private String status;
    @NotNull
    private ResourceEmployeeDTO employee;

    public ResourceUserDTO() {
    }

    public ResourceUserDTO(String id, String username, String password, String status, ResourceEmployeeDTO employee) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResourceEmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(ResourceEmployeeDTO employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceUserDTO entity = (ResourceUserDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.employee, entity.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, status, employee);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "username = " + username + ", " +
                "status = " + status + ", " +
                "employee = " + employee + ")";
    }
}