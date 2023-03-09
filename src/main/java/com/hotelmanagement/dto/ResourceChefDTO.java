package com.hotelmanagement.dto;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Chef} entity
 */
public class ResourceChefDTO implements Serializable {
    @Size(max = 8)
    private String id;
    private ResourceEmployeeDTO employee;

    public ResourceChefDTO() {
    }

    public ResourceChefDTO(String id, ResourceEmployeeDTO employee) {
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
        ResourceChefDTO entity = (ResourceChefDTO) o;
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