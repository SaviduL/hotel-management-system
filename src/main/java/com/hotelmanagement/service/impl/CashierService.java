package com.hotelmanagement.service.impl;

import com.hotelmanagement.repository.CashierRepository;
import com.hotelmanagement.service.CashierServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashierService implements CashierServiceable {

    @Autowired
    private CashierRepository cashierRepository;
}
