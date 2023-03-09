package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Advance} entity
 */
public class StoreAdvanceDTO implements Serializable {
    @Size(max = 100)
    @NotNull
    private String description;
    @NotNull
    private BigDecimal amount;
    @Size(max = 8)
    private String employeeId;
    @Size(max = 8)
    private String handlerManagerId;

    public StoreAdvanceDTO() {
    }

    public StoreAdvanceDTO(String description, BigDecimal amount, String employeeId, String handlerManagerId) {
        this.description = description;
        this.amount = amount;
        this.employeeId = employeeId;
        this.handlerManagerId = handlerManagerId;
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getHandlerManagerId() {
        return handlerManagerId;
    }

    public void setHandlerManagerId(String handlerManagerId) {
        this.handlerManagerId = handlerManagerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreAdvanceDTO entity = (StoreAdvanceDTO) o;
        return Objects.equals(this.description, entity.description) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.employeeId, entity.employeeId) &&
                Objects.equals(this.handlerManagerId, entity.handlerManagerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, amount, employeeId, handlerManagerId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "description = " + description + ", " +
                "amount = " + amount + ", " +
                "employeeId = " + employeeId + ", " +
                "handlerManagerId = " + handlerManagerId + ")";
    }
}