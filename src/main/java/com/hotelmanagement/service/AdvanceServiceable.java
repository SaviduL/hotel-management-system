package com.hotelmanagement.service;

import com.hotelmanagement.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdvanceServiceable {
    List<ResourceAdvanceDTO> getAllAdvances();

    ResponseEntity<Boolean> createAdvance(StoreAdvanceDTO storeAdvanceDTO);

    ResourceAdvanceDTO getAdvanceByID(Integer id);

    ResponseEntity<Boolean> updateAdvance(UpdateAdvanceDTO updateAdvanceDTO);

    ResponseEntity<Boolean> deleteAdvance(Integer id);

}
