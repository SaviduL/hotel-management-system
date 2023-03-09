package com.hotelmanagement.controller;

import com.hotelmanagement.dto.*;
import com.hotelmanagement.service.UserServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1.0/users")
public class UserController {
    @Autowired
    private UserServiceable userServiceable;

    @GetMapping()
    public ResponseEntity<List<ResourceUserDTO>> index() {
        return ResponseEntity.ok(userServiceable.getAllUsers());
    }

    @PostMapping()
    public ResponseEntity<Boolean> store(@RequestBody StoreUserDTO storeUserDTO) {
        return userServiceable.createUser(storeUserDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceUserDTO> show(@PathVariable String id) {
        return ResponseEntity.ok(userServiceable.getUserByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable String id, @RequestBody UpdateUserDTO updateUserDTO) {
        updateUserDTO.setId(id);
        return userServiceable.updateUser(updateUserDTO);
    }

    @PutMapping("/changePassword/{id}")
    public ResponseEntity<Boolean> changePassword(@PathVariable String id, @RequestBody ChangePasswordUserDTO changePasswordUserDTO) {
        changePasswordUserDTO.setId(id);
        return userServiceable.changeUserPassword(changePasswordUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable String id) {
        return userServiceable.deleteUser(id);
    }
}
