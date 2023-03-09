package com.hotelmanagement.service;

import com.hotelmanagement.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceable {
    List<ResourceUserDTO> getAllUsers();

    ResponseEntity<Boolean> createUser(StoreUserDTO storeUserDTO);

    ResourceUserDTO getUserByID(String id);

    ResponseEntity<Boolean> updateUser(UpdateUserDTO updateUserDTO);

    ResponseEntity<Boolean> changeUserPassword(ChangePasswordUserDTO changePasswordUserDTO);

    ResponseEntity<Boolean> deleteUser(String id);
}
