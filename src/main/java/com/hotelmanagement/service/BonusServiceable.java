package com.hotelmanagement.service;

import com.hotelmanagement.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BonusServiceable {
    List<ResourceBonusDTO> getAllBonuses();

    ResponseEntity<Boolean> createBonus(StoreBonusDTO storeBonusDTO);

    ResourceBonusDTO getBonusByID(Integer id);

    ResponseEntity<Boolean> updateBonus(UpdateBonusDTO updateBonusDTO);

    ResponseEntity<Boolean> deleteBonus(Integer id);
}
