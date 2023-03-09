package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    @Procedure(procedureName = "addItem")
    void addItem(
            String name,
            String category,
            String description,
            BigDecimal price,
            String image
    );

    @Procedure(procedureName = "updateItem")
    void updateItem(
            String id,
            String name,
            String category,
            String description,
            BigDecimal price,
            String image
    );

    @Procedure(procedureName = "deleteItem")
    void deleteItem(String id);

    @Query(
            value = "SELECT * FROM items_view",
            nativeQuery = true)
    List<Item> findAll();

    @Query(
            value = "SELECT * FROM items_view WHERE itemID = ?1",
            nativeQuery = true)
    Item getById(String id);
}