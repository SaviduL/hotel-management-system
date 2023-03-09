package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiterRepository extends JpaRepository<Waiter, String> {
}