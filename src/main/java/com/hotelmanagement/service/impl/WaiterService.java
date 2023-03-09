package com.hotelmanagement.service.impl;

import com.hotelmanagement.repository.WaiterRepository;
import com.hotelmanagement.service.WaiterServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaiterService implements WaiterServiceable {

    @Autowired
    private WaiterRepository waiterRepository;
}
