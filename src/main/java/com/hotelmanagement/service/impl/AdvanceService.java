package com.hotelmanagement.service.impl;

import com.hotelmanagement.dto.*;
import com.hotelmanagement.entity.Advance;
import com.hotelmanagement.mapper.*;
import com.hotelmanagement.repository.AdvanceRepository;
import com.hotelmanagement.service.AdvanceServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvanceService implements AdvanceServiceable {

    @Autowired
    private AdvanceRepository advanceRepository;
    @Autowired
    private StoreAdvanceMapper storeAdvanceMapper;
    @Autowired
    private UpdateAdvanceMapper updateAdvanceMapper;
    @Autowired
    private ResourceAdvanceMapper resourceAdvanceMapper;

    @Override
    public List<ResourceAdvanceDTO> getAllAdvances() {
        return advanceRepository.findAll().stream()
                .map(resourceAdvanceMapper::advanceToResourceAdvanceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Boolean> createAdvance(StoreAdvanceDTO storeAdvanceDTO) {
        Advance advance = storeAdvanceMapper.storeAdvanceDTOToAdvance(storeAdvanceDTO);
        advanceRepository.addAdvance(
                advance.getDescription(),
                advance.getAmount(),
                advance.getEmployeeID().getId(),
                advance.getHandlerManagerID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResourceAdvanceDTO getAdvanceByID(Integer id) {
        return resourceAdvanceMapper.advanceToResourceAdvanceDTO(advanceRepository.getById(id));
    }

    @Override
    public ResponseEntity<Boolean> updateAdvance(UpdateAdvanceDTO updateAdvanceDTO) {
        Advance advance = updateAdvanceMapper.updateAdvanceDTOToAdvance(updateAdvanceDTO);
        advanceRepository.updateAdvance(
                advance.getId(),
                advance.getDescription(),
                advance.getAmount(),
                advance.getEmployeeID().getId(),
                advance.getHandlerManagerID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> deleteAdvance(Integer id) {
        advanceRepository.deleteAdvance(id);
        return ResponseEntity.ok(true);
    }
}
