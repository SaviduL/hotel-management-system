package com.hotelmanagement.repository;

import com.hotelmanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Procedure(procedureName = "addOrder")
    Integer addOrder(String waiterID);

    @Procedure(procedureName = "acceptOrderBychef")
    void acceptOrderBychef(Integer id, String chefID);

    @Procedure(procedureName = "preparedOrderBychef")
    void preparedOrderBychef(Integer id, String chefID);

    @Procedure(procedureName = "completeOrder")
    void completeOrder(Integer id, String cashierID);

    @Procedure(procedureName = "cancelOrder")
    void cancelOrder(Integer id, String chefID);

    @Procedure(procedureName = "deleteOrder")
    void deleteOrder(Integer id);

    @Query(
            value = "SELECT * FROM orders_view",
            nativeQuery = true)
    List<Order> findAll();

    @Query(
            value = "SELECT * FROM orders_view WHERE orderID = ?1",
            nativeQuery = true)
    Order getById(Integer id);
}