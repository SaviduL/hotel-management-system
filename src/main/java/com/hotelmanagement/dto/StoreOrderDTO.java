package com.hotelmanagement.dto;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Order} entity
 */
public class StoreOrderDTO implements Serializable {
    @Size(max = 8)
    private String waiterId;
    private Set<StoreBillDTO> bills = new LinkedHashSet<>();

    public StoreOrderDTO() {
    }

    public StoreOrderDTO(String waiterId, Set<StoreBillDTO> bills) {
        this.waiterId = waiterId;
        this.bills = bills;
    }

    public String getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }

    public Set<StoreBillDTO> getBills() {
        return bills;
    }

    public void setBills(Set<StoreBillDTO> bills) {
        this.bills = bills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreOrderDTO entity = (StoreOrderDTO) o;
        return Objects.equals(this.waiterId, entity.waiterId) &&
                Objects.equals(this.bills, entity.bills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(waiterId, bills);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "waiterId = " + waiterId + ", " +
                "bills = " + bills + ")";
    }
}