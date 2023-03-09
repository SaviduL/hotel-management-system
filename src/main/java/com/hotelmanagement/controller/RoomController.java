package com.hotelmanagement.controller;

import com.hotelmanagement.dto.ResourceRoomDTO;
import com.hotelmanagement.dto.StoreRoomDTO;
import com.hotelmanagement.dto.UpdateRoomDTO;
import com.hotelmanagement.service.RoomServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1.0/rooms")
public class RoomController {
    @Autowired
    private RoomServiceable roomServiceable;

    @GetMapping()
    public ResponseEntity<List<ResourceRoomDTO>> index() {
        return ResponseEntity.ok(roomServiceable.getAllRooms());
    }

    @PostMapping()
    public ResponseEntity<Boolean> store(@RequestBody StoreRoomDTO storeRoomDTO) {
        return roomServiceable.createRoom(storeRoomDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceRoomDTO> show(@PathVariable String id) {
        return ResponseEntity.ok(roomServiceable.getRoomByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Integer id, @RequestBody UpdateRoomDTO updateRoomDTO) {
        updateRoomDTO.setId(id);
        return roomServiceable.updateRoom(updateRoomDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Integer id) {
        return roomServiceable.deleteRoom(id);
    }
}
