package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionistRepository extends JpaRepository<Receptionist, String> {
}