package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Bill} entity
 */
public class StoreBillDTO implements Serializable {
    private Integer orderId;
    @Size(max = 8)
    private String itemId;
    @NotNull
    private BigDecimal unitPrice;
    @NotNull
    private Integer quantity;

    public StoreBillDTO() {
    }

    public StoreBillDTO(Integer orderId, String itemId, BigDecimal unitPrice, Integer quantity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreBillDTO entity = (StoreBillDTO) o;
        return Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.itemId, entity.itemId) &&
                Objects.equals(this.unitPrice, entity.unitPrice) &&
                Objects.equals(this.quantity, entity.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemId, unitPrice, quantity);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "orderId = " + orderId + ", " +
                "itemId = " + itemId + ", " +
                "unitPrice = " + unitPrice + ", " +
                "quantity = " + quantity + ")";
    }
}