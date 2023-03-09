package com.hotelmanagement.service.impl;

import com.hotelmanagement.dto.*;
import com.hotelmanagement.entity.Bonus;
import com.hotelmanagement.mapper.*;
import com.hotelmanagement.repository.BonusRepository;
import com.hotelmanagement.service.BonusServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BonusService implements BonusServiceable {

    @Autowired
    private BonusRepository bonusRepository;
    @Autowired
    private StoreBonusMapper storeBonusMapper;
    @Autowired
    private UpdateBonusMapper updateBonusMapper;
    @Autowired
    private ResourceBonusMapper resourceBonusMapper;

    @Override
    public List<ResourceBonusDTO> getAllBonuses() {
        return bonusRepository.findAll().stream()
                .map(resourceBonusMapper::bonusToResourceBonusDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Boolean> createBonus(StoreBonusDTO storeBonusDTO) {
        Bonus bonus = storeBonusMapper.storeBonusDTOToBonus(storeBonusDTO);
        bonusRepository.addBonus(
                bonus.getEmployeeID().getId(),
                bonus.getAmount(),
                bonus.getDescription()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResourceBonusDTO getBonusByID(Integer id) {
        return resourceBonusMapper.bonusToResourceBonusDTO(bonusRepository.getById(id));
    }

    @Override
    public ResponseEntity<Boolean> updateBonus(UpdateBonusDTO updateBonusDTO) {
        Bonus bonus = updateBonusMapper.updateBonusDTOToBonus(updateBonusDTO);
        bonusRepository.updateBonus(
                bonus.getId(),
                bonus.getEmployeeID().getId(),
                bonus.getAmount(),
                bonus.getDescription()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> deleteBonus(Integer id) {
        bonusRepository.deleteBonus(id);
        return ResponseEntity.ok(true);
    }
}
