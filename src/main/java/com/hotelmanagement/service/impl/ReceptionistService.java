package com.hotelmanagement.service.impl;

import com.hotelmanagement.repository.ReceptionistRepository;
import com.hotelmanagement.service.ReceptionistServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceptionistService  implements ReceptionistServiceable {

    @Autowired
    private ReceptionistRepository receptionistRepository;
}
