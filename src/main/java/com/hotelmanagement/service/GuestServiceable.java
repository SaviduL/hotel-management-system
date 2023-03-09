package com.hotelmanagement.service;

import com.hotelmanagement.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GuestServiceable {
    List<ResourceGuestDTO> getAllGuests();

    ResponseEntity<Boolean> createGuest(StoreGuestDTO storeGuestDTO);

    ResourceGuestDTO getGuestByID(String id);

    ResponseEntity<Boolean> updateGuest(UpdateGuestDTO updateGuestDTO);

    ResponseEntity<Boolean> deleteGuest(String id);
}
