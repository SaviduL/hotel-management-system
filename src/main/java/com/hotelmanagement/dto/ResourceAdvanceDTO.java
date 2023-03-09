package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Advance} entity
 */
public class ResourceAdvanceDTO implements Serializable {
    private Integer id;
    @Size(max = 100)
    @NotNull
    private String description;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private LocalDate date;
    @NotNull
    private ResourceEmployeeDTO employee;
    @NotNull
    private ResourceManagerDTO handlerManager;

    public ResourceAdvanceDTO() {
    }

    public ResourceAdvanceDTO(Integer id, String description, BigDecimal amount, LocalDate date, ResourceEmployeeDTO employee, ResourceManagerDTO handlerManager) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.employee = employee;
        this.handlerManager = handlerManager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ResourceEmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(ResourceEmployeeDTO employee) {
        this.employee = employee;
    }

    public ResourceManagerDTO getHandlerManager() {
        return handlerManager;
    }

    public void setHandlerManager(ResourceManagerDTO handlerManager) {
        this.handlerManager = handlerManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceAdvanceDTO entity = (ResourceAdvanceDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.date, entity.date) &&
                Objects.equals(this.employee, entity.employee) &&
                Objects.equals(this.handlerManager, entity.handlerManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, amount, date, employee, handlerManager);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "description = " + description + ", " +
                "amount = " + amount + ", " +
                "date = " + date + ", " +
                "employee = " + employee + ", " +
                "handlerManager = " + handlerManager + ")";
    }
}