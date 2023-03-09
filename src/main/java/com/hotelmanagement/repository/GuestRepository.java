package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String> {
    @Procedure(procedureName = "addGuest")
    void addGuest(
            String telNo,
            String title,
            String nic,
            String firstName,
            String lastName,
            String sex,
            String address,
            String email
    );

    @Procedure(procedureName = "updateGuest")
    void updateGuest(
            String id,
            String title,
            String nic,
            String firstName,
            String lastName,
            String sex,
            String address,
            String email
    );

    @Procedure(procedureName = "deleteGuest")
    void deleteGuest(String id);

    @Query(
            value = "SELECT * FROM guests_view",
            nativeQuery = true)
    List<Guest> findAll();

    @Query(
            value = "SELECT * FROM guests_view WHERE telNo = ?1",
            nativeQuery = true)
    Guest getById(String id);
}