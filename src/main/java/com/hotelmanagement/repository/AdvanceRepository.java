package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Advance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AdvanceRepository extends JpaRepository<Advance, Integer> {
    @Procedure(procedureName = "addAdvance")
    void addAdvance(
            String description,
            BigDecimal amount,
            String employeeID,
            String handlerManagerID
    );

    @Procedure(procedureName = "updateAdvance")
    void updateAdvance(
            Integer id,
            String description,
            BigDecimal amount,
            String employeeID,
            String handlerManagerID
    );

    @Procedure(procedureName = "deleteAdvance")
    void deleteAdvance(Integer id);

    @Query(
            value = "SELECT * FROM advances_view",
            nativeQuery = true)
    List<Advance> findAll();

    @Query(
            value = "SELECT * FROM advances_view WHERE advanceID = ?1",
            nativeQuery = true)
    Advance getById(Integer id);
}