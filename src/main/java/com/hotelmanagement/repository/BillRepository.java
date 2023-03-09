package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Bill;
import com.hotelmanagement.entity.BillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BillRepository extends JpaRepository<Bill, BillId> {
    @Procedure(procedureName = "addBill")
    void addBill(Integer orderID, String itemID, BigDecimal unitPrice, Integer quantity);
}