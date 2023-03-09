package com.hotelmanagement.service.impl;

import com.hotelmanagement.dto.*;
import com.hotelmanagement.entity.User;
import com.hotelmanagement.mapper.*;;
import com.hotelmanagement.repository.UserRepository;
import com.hotelmanagement.service.UserServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceable {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StoreUserMapper storeUserMapper;
    @Autowired
    private UpdateUserMapper updateUserMapper;
    @Autowired
    private ResourceUserMapper resourceUserMapper;
    @Autowired
    private ChangePasswordUserMapper changePasswordUserMapper;

    @Override
    public List<ResourceUserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(resourceUserMapper::userToResourceUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Boolean> createUser(StoreUserDTO storeUserDTO) {
        User user = storeUserMapper.storeUserDTOToUser(storeUserDTO);
        userRepository.addUser(
                user.getUsername(),
                user.getPassword(),
                user.getEmployeeID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResourceUserDTO getUserByID(String id) {
        return resourceUserMapper.userToResourceUserDTO(userRepository.getById(id));
    }

    @Override
    public ResponseEntity<Boolean> updateUser(UpdateUserDTO updateUserDTO) {
        User user = updateUserMapper.updateUserDTOToUser(updateUserDTO);
        userRepository.updateUser(
                user.getId(),
                user.getUsername(),
                user.getStatus()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> changeUserPassword(ChangePasswordUserDTO changePasswordUserDTO) {
        User user = changePasswordUserMapper.changePasswordUserDTOToUser(changePasswordUserDTO);
        userRepository.changeUserPassword(user.getId(), user.getPassword());
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> deleteUser(String id) {
        userRepository.deleteUser(id);
        return ResponseEntity.ok(true);
    }
}
