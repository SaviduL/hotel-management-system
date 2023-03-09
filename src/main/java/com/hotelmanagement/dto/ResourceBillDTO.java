package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Bill} entity
 */
public class ResourceBillDTO implements Serializable {
    private Integer orderId;
    private ResourceItemDTO item;
    @NotNull
    private BigDecimal unitPrice;
    @NotNull
    private Integer quantity;

    public ResourceBillDTO() {
    }

    public ResourceBillDTO(Integer orderId, ResourceItemDTO item, BigDecimal unitPrice, Integer quantity) {
        this.orderId = orderId;
        this.item = item;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public ResourceItemDTO getItem() {
        return item;
    }

    public void setItem(ResourceItemDTO item) {
        this.item = item;
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
        ResourceBillDTO entity = (ResourceBillDTO) o;
        return Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.item, entity.item) &&
                Objects.equals(this.unitPrice, entity.unitPrice) &&
                Objects.equals(this.quantity, entity.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, item, unitPrice, quantity);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "orderId = " + orderId + ", " +
                "item = " + item + ", " +
                "unitPrice = " + unitPrice + ", " +
                "quantity = " + quantity + ")";
    }
}