package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Integer> {
    @Procedure(procedureName = "addBonus")
    void addBonus(
            String employeeID,
            BigDecimal amount,
            String description
    );

    @Procedure(procedureName = "updateBonus")
    void updateBonus(
            Integer id,
            String employeeID,
            BigDecimal amount,
            String description
    );

    @Procedure(procedureName = "deleteBonus")
    void deleteBonus(Integer id);

    @Query(
            value = "SELECT * FROM bonuses_view",
            nativeQuery = true)
    List<Bonus> findAll();

    @Query(
            value = "SELECT * FROM bonuses_view WHERE bonusID = ?1",
            nativeQuery = true)
    Bonus getById(Integer id);
}