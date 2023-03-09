package com.hotelmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.hotelmanagement.entity.Order} entity
 */
public class ResourceOrderDTO implements Serializable {
    private Integer id;
    @NotNull
    private Instant date;
    @Size(max = 20)
    @NotNull
    private String status;
    private BigDecimal netPrice;
    @Size(max = 8)
    private String waiterId;
    private ResourceEmployeeDTO waiterEmployee;
    @Size(max = 8)
    private String chefId;
    private ResourceEmployeeDTO chefEmployee;
    @Size(max = 8)
    private String cashierId;
    private ResourceEmployeeDTO cashierEmployee;
    private Set<BillDTO> bills = new LinkedHashSet<>();

    public ResourceOrderDTO() {
    }

    public ResourceOrderDTO(Integer id, Instant date, String status, BigDecimal netPrice, String waiterId, ResourceEmployeeDTO waiterEmployee, String chefId, ResourceEmployeeDTO chefEmployee, String cashierId, ResourceEmployeeDTO cashierEmployee, Set<BillDTO> bills) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.netPrice = netPrice;
        this.waiterId = waiterId;
        this.waiterEmployee = waiterEmployee;
        this.chefId = chefId;
        this.chefEmployee = chefEmployee;
        this.cashierId = cashierId;
        this.cashierEmployee = cashierEmployee;
        this.bills = bills;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public String getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }

    public ResourceEmployeeDTO getWaiterEmployee() {
        return waiterEmployee;
    }

    public void setWaiterEmployee(ResourceEmployeeDTO waiterEmployee) {
        this.waiterEmployee = waiterEmployee;
    }

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    public ResourceEmployeeDTO getChefEmployee() {
        return chefEmployee;
    }

    public void setChefEmployee(ResourceEmployeeDTO chefEmployee) {
        this.chefEmployee = chefEmployee;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public ResourceEmployeeDTO getCashierEmployee() {
        return cashierEmployee;
    }

    public void setCashierEmployee(ResourceEmployeeDTO cashierEmployee) {
        this.cashierEmployee = cashierEmployee;
    }

    public Set<BillDTO> getBills() {
        return bills;
    }

    public void setBills(Set<BillDTO> bills) {
        this.bills = bills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceOrderDTO entity = (ResourceOrderDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.date, entity.date) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.netPrice, entity.netPrice) &&
                Objects.equals(this.waiterId, entity.waiterId) &&
                Objects.equals(this.waiterEmployee, entity.waiterEmployee) &&
                Objects.equals(this.chefId, entity.chefId) &&
                Objects.equals(this.chefEmployee, entity.chefEmployee) &&
                Objects.equals(this.cashierId, entity.cashierId) &&
                Objects.equals(this.cashierEmployee, entity.cashierEmployee) &&
                Objects.equals(this.bills, entity.bills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, status, netPrice, waiterId, waiterEmployee, chefId, chefEmployee, cashierId, cashierEmployee, bills);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "date = " + date + ", " +
                "status = " + status + ", " +
                "netPrice = " + netPrice + ", " +
                "waiterId = " + waiterId + ", " +
                "waiterEmployee = " + waiterEmployee + ", " +
                "chefId = " + chefId + ", " +
                "chefEmployee = " + chefEmployee + ", " +
                "cashierId = " + cashierId + ", " +
                "cashierEmployee = " + cashierEmployee + ", " +
                "bills = " + bills + ")";
    }

    /**
     * A DTO for the {@link com.hotelmanagement.entity.Bill} entity
     */
    public static class BillDTO implements Serializable {
        private Integer orderIDId;
        private ResourceItemDTO itemID;
        @NotNull
        private BigDecimal unitPrice;
        @NotNull
        private Integer quantity;

        public BillDTO() {
        }

        public BillDTO(Integer orderIDId, ResourceItemDTO itemID, BigDecimal unitPrice, Integer quantity) {
            this.orderIDId = orderIDId;
            this.itemID = itemID;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        public Integer getOrderIDId() {
            return orderIDId;
        }

        public void setOrderIDId(Integer orderIDId) {
            this.orderIDId = orderIDId;
        }

        public ResourceItemDTO getItemID() {
            return itemID;
        }

        public void setItemID(ResourceItemDTO itemID) {
            this.itemID = itemID;
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
            BillDTO entity = (BillDTO) o;
            return Objects.equals(this.orderIDId, entity.orderIDId) &&
                    Objects.equals(this.itemID, entity.itemID) &&
                    Objects.equals(this.unitPrice, entity.unitPrice) &&
                    Objects.equals(this.quantity, entity.quantity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderIDId, itemID, unitPrice, quantity);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "orderIDId = " + orderIDId + ", " +
                    "itemID = " + itemID + ", " +
                    "unitPrice = " + unitPrice + ", " +
                    "quantity = " + quantity + ")";
        }
    }
}