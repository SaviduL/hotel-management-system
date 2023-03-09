package com.hotelmanagement.controller;

import com.hotelmanagement.dto.ResourceGuestDTO;
import com.hotelmanagement.dto.StoreGuestDTO;
import com.hotelmanagement.dto.UpdateGuestDTO;
import com.hotelmanagement.service.GuestServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1.0/guests")
public class GuestController {
    @Autowired
    private GuestServiceable guestServiceable;

    @GetMapping()
    public ResponseEntity<List<ResourceGuestDTO>> index() {
        return ResponseEntity.ok(guestServiceable.getAllGuests());
    }

    @PostMapping()
    public ResponseEntity<Boolean> store(@RequestBody StoreGuestDTO storeGuestDTO) {
        return guestServiceable.createGuest(storeGuestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceGuestDTO> show(@PathVariable String id) {
        return ResponseEntity.ok(guestServiceable.getGuestByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable String id, @RequestBody UpdateGuestDTO updateGuestDTO) {
        updateGuestDTO.setId(id);
        return guestServiceable.updateGuest(updateGuestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable String id) {
        return guestServiceable.deleteGuest(id);
    }
}
