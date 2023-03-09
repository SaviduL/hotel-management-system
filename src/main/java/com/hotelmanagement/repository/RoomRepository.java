package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Procedure(procedureName = "addRoom")
    void addRoom(
            String name,
            Integer roomNo,
            String description,
            String bedType,
            Integer noOfBed,
            String roomType,
            BigDecimal charge
    );

    @Procedure(procedureName = "updateRoom")
    void updateRoom(
            Integer id,
            String name,
            Integer roomNo,
            String description,
            String bedType,
            Integer noOfBed,
            String roomType,
            BigDecimal charge
    );

    @Procedure(procedureName = "deleteRoom")
    void deleteRoom(Integer id);

    @Query(
            value = "SELECT * FROM rooms_view",
            nativeQuery = true)
    List<Room> findAll();

    @Query(
            value = "SELECT * FROM rooms_view WHERE roomID = ?1",
            nativeQuery = true)
    Room getById(String id);
}