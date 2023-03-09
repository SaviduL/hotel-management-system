package com.hotelmanagement.service.impl;

import com.hotelmanagement.entity.Bill;
import com.hotelmanagement.repository.BillRepository;
import com.hotelmanagement.service.BillServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BillService implements BillServiceable {

    @Autowired
    private BillRepository billRepository;

    @Override
    public ResponseEntity<Boolean> createBill(Set<Bill> bills) {
        for (Bill bill : bills) {
            billRepository.addBill(
                    bill.getId().getOrderID(),
                    bill.getId().getItemID(),
                    bill.getUnitPrice(),
                    bill.getQuantity()
            );
        }

        return ResponseEntity.ok(true);
    }
}
