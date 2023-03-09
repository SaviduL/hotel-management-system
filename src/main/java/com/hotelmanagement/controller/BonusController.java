package com.hotelmanagement.controller;

import com.hotelmanagement.dto.*;
import com.hotelmanagement.service.BonusServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1.0/bonuses")
public class BonusController {
    @Autowired
    private BonusServiceable bonusServiceable;

    @GetMapping()
    public ResponseEntity<List<ResourceBonusDTO>> index() {
        return ResponseEntity.ok(bonusServiceable.getAllBonuses());
    }

    @PostMapping()
    public ResponseEntity<Boolean> store(@RequestBody StoreBonusDTO storeBonusDTO) {
        return bonusServiceable.createBonus(storeBonusDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceBonusDTO> show(@PathVariable Integer id) {
        return ResponseEntity.ok(bonusServiceable.getBonusByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Integer id, @RequestBody UpdateBonusDTO updateBonusDTO) {
        updateBonusDTO.setId(id);
        return bonusServiceable.updateBonus(updateBonusDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Integer id) {
        return bonusServiceable.deleteBonus(id);
    }

}
