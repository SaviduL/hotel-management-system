package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Bonus} entity
 */
public class UpdateBonusDTO implements Serializable {
    private Integer id;
    @Size(max = 8)
    private String employeeId;
    @NotNull
    private BigDecimal amount;
    @Size(max = 100)
    @NotNull
    private String description;

    public UpdateBonusDTO() {
    }

    public UpdateBonusDTO(Integer id, String employeeId, BigDecimal amount, String description) {
        this.id = id;
        this.employeeId = employeeId;
        this.amount = amount;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateBonusDTO entity = (UpdateBonusDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.employeeId, entity.employeeId) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, amount, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "employeeId = " + employeeId + ", " +
                "amount = " + amount + ", " +
                "description = " + description + ")";
    }
}