package com.hotelmanagement.repository;

import com.hotelmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Procedure(procedureName = "addUser")
    void addUser(
            String username,
            String password,
            String employeeID
    );

    @Procedure(procedureName = "updateUser")
    void updateUser(
            String id,
            String username,
            String status
    );

    @Procedure(procedureName = "deleteUser")
    void deleteUser(String id);

    @Procedure(procedureName = "changeUserPassword")
    void changeUserPassword(String id, String password);

    @Query(
            value = "SELECT * FROM users_view",
            nativeQuery = true)
    List<User> findAll();

    @Query(
            value = "SELECT * FROM users_view WHERE userID = ?1",
            nativeQuery = true)
    User getById(String id);
}