package com.hotelmanagement.controller;

import com.hotelmanagement.dto.*;
import com.hotelmanagement.service.AdvanceServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1.0/advances")
public class AdvanceController {
    @Autowired
    private AdvanceServiceable advanceServiceable;

    @GetMapping()
    public ResponseEntity<List<ResourceAdvanceDTO>> index() {
        return ResponseEntity.ok(advanceServiceable.getAllAdvances());
    }

    @PostMapping()
    public ResponseEntity<Boolean> store(@RequestBody StoreAdvanceDTO storeAdvanceDTO) {
        return advanceServiceable.createAdvance(storeAdvanceDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceAdvanceDTO> show(@PathVariable Integer id) {
        return ResponseEntity.ok(advanceServiceable.getAdvanceByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Integer id, @RequestBody UpdateAdvanceDTO updateAdvanceDTO) {
        updateAdvanceDTO.setId(id);
        return advanceServiceable.updateAdvance(updateAdvanceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Integer id) {
        return advanceServiceable.deleteAdvance(id);
    }
}
