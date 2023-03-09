package com.hotelmanagement.dto;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Order} entity
 */
public class ChangeStatusOrderDTO implements Serializable {
    private Integer id;
    @Size(max = 8)
    private String chefId;
    @Size(max = 8)
    private String cashierId;

    public ChangeStatusOrderDTO() {
    }

    public ChangeStatusOrderDTO(Integer id, String chefId, String cashierId) {
        this.id = id;
        this.chefId = chefId;
        this.cashierId = cashierId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeStatusOrderDTO entity = (ChangeStatusOrderDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.chefId, entity.chefId) &&
                Objects.equals(this.cashierId, entity.cashierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chefId, cashierId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "chefId = " + chefId + ", " +
                "cashierId = " + cashierId + ")";
    }
}