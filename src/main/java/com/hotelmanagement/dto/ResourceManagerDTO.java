package com.hotelmanagement.dto;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Manager} entity
 */
public class ResourceManagerDTO implements Serializable {
    @Size(max = 8)
    private String id;
    private ResourceEmployeeDTO employee;

    public ResourceManagerDTO() {
    }

    public ResourceManagerDTO(String id, ResourceEmployeeDTO employee) {
        this.id = id;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        ResourceManagerDTO entity = (ResourceManagerDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.employee, entity.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "employee = " + employee + ")";
    }
}