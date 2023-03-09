package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashierRepository extends JpaRepository<Cashier, String> {
}