package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository<Chef, String> {
}