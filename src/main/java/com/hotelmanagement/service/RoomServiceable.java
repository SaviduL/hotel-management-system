package com.hotelmanagement.service;

import com.hotelmanagement.dto.ResourceRoomDTO;
import com.hotelmanagement.dto.StoreRoomDTO;
import com.hotelmanagement.dto.UpdateRoomDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomServiceable {
    List<ResourceRoomDTO> getAllRooms();

    ResponseEntity<Boolean> createRoom(StoreRoomDTO storeRoomDTO);

    ResourceRoomDTO getRoomByID(String id);

    ResponseEntity<Boolean> updateRoom(UpdateRoomDTO updateRoomDTO);

    ResponseEntity<Boolean> deleteRoom(Integer id);
}
