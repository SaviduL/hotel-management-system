package com.hotelmanagement.service.impl;

import com.hotelmanagement.repository.ManagerRepository;
import com.hotelmanagement.service.ManagerServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService implements ManagerServiceable {

    @Autowired
    private ManagerRepository managerRepository;
}
