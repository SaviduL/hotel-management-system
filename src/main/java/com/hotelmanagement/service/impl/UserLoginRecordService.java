package com.hotelmanagement.service.impl;

import com.hotelmanagement.repository.UserLoginRecordRepository;
import com.hotelmanagement.service.UserLoginRecordServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginRecordService implements UserLoginRecordServiceable {

    @Autowired
    private UserLoginRecordRepository userLoginRecordRepository;
}
