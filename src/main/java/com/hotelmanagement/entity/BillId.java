package com.hotelmanagement.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillId implements Serializable {
    private static final long serialVersionUID = -4792669573406641517L;
    @NotNull
    @Column(name = "orderID", nullable = false)
    private Integer orderID;

    @Size(max = 8)
    @NotNull
    @Column(name = "itemID", nullable = false, length = 8)
    private String itemID;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BillId entity = (BillId) o;
        return Objects.equals(this.itemID, entity.itemID) &&
                Objects.equals(this.orderID, entity.orderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID, orderID);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "serialVersionUID = " + serialVersionUID + ", " +
                "orderID = " + orderID + ", " +
                "itemID = " + itemID + ")";
    }
}