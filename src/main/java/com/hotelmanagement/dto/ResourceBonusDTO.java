package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Bonus} entity
 */
public class ResourceBonusDTO implements Serializable {
    private Integer id;
    @NotNull
    private ResourceEmployeeDTO employee;
    @NotNull
    private BigDecimal amount;
    @Size(max = 100)
    @NotNull
    private String description;
    @NotNull
    private LocalDate date;

    public ResourceBonusDTO() {
    }

    public ResourceBonusDTO(Integer id, ResourceEmployeeDTO employee, BigDecimal amount, String description, LocalDate date) {
        this.id = id;
        this.employee = employee;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResourceEmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(ResourceEmployeeDTO employee) {
        this.employee = employee;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceBonusDTO entity = (ResourceBonusDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.employee, entity.employee) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.date, entity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, amount, description, date);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "employee = " + employee + ", " +
                "amount = " + amount + ", " +
                "description = " + description + ", " +
                "date = " + date + ")";
    }
}