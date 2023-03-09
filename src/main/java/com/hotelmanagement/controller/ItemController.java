package com.hotelmanagement.controller;

import com.hotelmanagement.dto.ResourceItemDTO;
import com.hotelmanagement.dto.StoreItemDTO;
import com.hotelmanagement.dto.UpdateItemDTO;
import com.hotelmanagement.service.ItemServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1.0/items")
public class ItemController {

    @Autowired
    private ItemServiceable itemServiceable;

    @GetMapping()
    public ResponseEntity<List<ResourceItemDTO>> index() {
        return ResponseEntity.ok(itemServiceable.getAllItems());
    }

    @PostMapping()
    public ResponseEntity<Boolean> store(@RequestBody StoreItemDTO storeItemDTO) {
        return itemServiceable.createItem(storeItemDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceItemDTO> show(@PathVariable String id) {
        return ResponseEntity.ok(itemServiceable.getItemByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable String id, @RequestBody UpdateItemDTO updateItemDTO) {
        updateItemDTO.setId(id);
        return itemServiceable.updateItem(updateItemDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable String id) {
        return itemServiceable.deleteItem(id);
    }
}
