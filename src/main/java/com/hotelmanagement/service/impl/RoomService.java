package com.hotelmanagement.service.impl;

import com.hotelmanagement.dto.ResourceRoomDTO;
import com.hotelmanagement.dto.StoreRoomDTO;
import com.hotelmanagement.dto.UpdateRoomDTO;
import com.hotelmanagement.entity.Room;
import com.hotelmanagement.mapper.ResourceRoomMapper;
import com.hotelmanagement.mapper.StoreRoomMapper;
import com.hotelmanagement.mapper.UpdateRoomMapper;
import com.hotelmanagement.repository.RoomRepository;
import com.hotelmanagement.service.RoomServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements RoomServiceable {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private StoreRoomMapper storeRoomMapper;
    @Autowired
    private UpdateRoomMapper updateRoomMapper;
    @Autowired
    private ResourceRoomMapper resourceRoomMapper;

    @Override
    public List<ResourceRoomDTO> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(resourceRoomMapper::roomToResourceRoomDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Boolean> createRoom(StoreRoomDTO storeRoomDTO) {
        Room room = storeRoomMapper.storeRoomDTOToRoom(storeRoomDTO);
        roomRepository.addRoom(
                room.getName(),
                room.getRoomNo(),
                room.getDescription(),
                room.getBedType(),
                room.getNoOfBed(),
                room.getRoomType(),
                room.getCharge()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResourceRoomDTO getRoomByID(String id) {
        return resourceRoomMapper.roomToResourceRoomDTO(roomRepository.getById(id));
    }

    @Override
    public ResponseEntity<Boolean> updateRoom(UpdateRoomDTO updateRoomDTO) {
        Room room = updateRoomMapper.updateRoomDTOToRoom(updateRoomDTO);
        roomRepository.updateRoom(
                room.getId(),
                room.getName(),
                room.getRoomNo(),
                room.getDescription(),
                room.getBedType(),
                room.getNoOfBed(),
                room.getRoomType(),
                room.getCharge()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> deleteRoom(Integer id) {
        roomRepository.deleteRoom(id);
        return ResponseEntity.ok(true);
    }
}
