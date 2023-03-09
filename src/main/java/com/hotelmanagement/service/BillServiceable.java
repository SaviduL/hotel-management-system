package com.hotelmanagement.service;

import com.hotelmanagement.entity.Bill;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface BillServiceable {
    ResponseEntity<Boolean> createBill(Set<Bill> bills);
}
