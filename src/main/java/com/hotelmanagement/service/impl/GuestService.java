package com.hotelmanagement.service.impl;

import com.hotelmanagement.dto.ResourceGuestDTO;
import com.hotelmanagement.dto.StoreGuestDTO;
import com.hotelmanagement.dto.UpdateGuestDTO;
import com.hotelmanagement.entity.Guest;
import com.hotelmanagement.mapper.ResourceGuestMapper;
import com.hotelmanagement.mapper.StoreGuestMapper;
import com.hotelmanagement.mapper.UpdateGuestMapper;
import com.hotelmanagement.repository.GuestRepository;
import com.hotelmanagement.service.GuestServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService implements GuestServiceable {

    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private StoreGuestMapper storeGuestMapper;
    @Autowired
    private UpdateGuestMapper updateGuestMapper;
    @Autowired
    private ResourceGuestMapper resourceGuestMapper;

    @Override
    public List<ResourceGuestDTO> getAllGuests() {
        return guestRepository.findAll().stream()
                .map(resourceGuestMapper::guestToResourceGuestDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Boolean> createGuest(StoreGuestDTO storeGuestDTO) {
        Guest guest = storeGuestMapper.storeGuestDTOToGuest(storeGuestDTO);
        guestRepository.addGuest(
                guest.getId(),
                guest.getTitle(),
                guest.getNic(),
                guest.getFirstName(),
                guest.getLastName(),
                guest.getSex(),
                guest.getAddress(),
                guest.getEmail()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResourceGuestDTO getGuestByID(String id) {
        return resourceGuestMapper.guestToResourceGuestDTO(guestRepository.getById(id));
    }

    @Override
    public ResponseEntity<Boolean> updateGuest(UpdateGuestDTO updateGuestDTO) {
        Guest guest = updateGuestMapper.updateGuestDTOToGuest(updateGuestDTO);
        guestRepository.updateGuest(
                guest.getId(),
                guest.getTitle(),
                guest.getNic(),
                guest.getFirstName(),
                guest.getLastName(),
                guest.getSex(),
                guest.getAddress(),
                guest.getEmail()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> deleteGuest(String id) {
        guestRepository.deleteGuest(id);
        return ResponseEntity.ok(true);
    }
}
