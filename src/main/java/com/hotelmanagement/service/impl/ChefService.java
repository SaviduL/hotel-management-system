package com.hotelmanagement.service.impl;

import com.hotelmanagement.repository.ChefRepository;
import com.hotelmanagement.service.ChefServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChefService implements ChefServiceable {

    @Autowired
    private ChefRepository chefRepository;
}
