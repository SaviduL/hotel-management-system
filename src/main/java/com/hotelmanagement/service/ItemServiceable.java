package com.hotelmanagement.service;

import com.hotelmanagement.dto.ResourceItemDTO;
import com.hotelmanagement.dto.StoreItemDTO;
import com.hotelmanagement.dto.UpdateItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemServiceable {
    List<ResourceItemDTO> getAllItems();

    ResponseEntity<Boolean> createItem(StoreItemDTO storeItemDTO);

    ResourceItemDTO getItemByID(String id);

    ResponseEntity<Boolean> updateItem(UpdateItemDTO updateItemDTO);

    ResponseEntity<Boolean> deleteItem(String id);
}
