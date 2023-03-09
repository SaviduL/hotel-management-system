package com.hotelmanagement.service.impl;

import com.hotelmanagement.dto.ResourceItemDTO;
import com.hotelmanagement.dto.StoreItemDTO;
import com.hotelmanagement.dto.UpdateItemDTO;
import com.hotelmanagement.entity.Item;
import com.hotelmanagement.mapper.ResourceItemMapper;
import com.hotelmanagement.mapper.StoreItemMapper;
import com.hotelmanagement.mapper.UpdateItemMapper;
import com.hotelmanagement.repository.ItemRepository;
import com.hotelmanagement.service.ItemServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService implements ItemServiceable {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private StoreItemMapper storeItemMapper;
    @Autowired
    private UpdateItemMapper updateItemMapper;
    @Autowired
    private ResourceItemMapper resourceItemMapper;

    @Override
    public List<ResourceItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
                .map(resourceItemMapper::itemToResourceItemDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Boolean> createItem(StoreItemDTO storeItemDTO) {
        Item item = storeItemMapper.storeItemDTOToItem(storeItemDTO);
        itemRepository.addItem(
                item.getName(),
                item.getCategory(),
                item.getDescription(),
                item.getPrice(),
                item.getImage()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResourceItemDTO getItemByID(String id) {
        return resourceItemMapper.itemToResourceItemDTO(itemRepository.getById(id));
    }

    @Override
    public ResponseEntity<Boolean> updateItem(UpdateItemDTO updateItemDTO) {
        Item item = updateItemMapper.updateItemDTOToItem(updateItemDTO);
        itemRepository.updateItem(
                item.getId(),
                item.getName(),
                item.getCategory(),
                item.getDescription(),
                item.getPrice(),
                item.getImage()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> deleteItem(String id) {
        itemRepository.deleteItem(id);
        return ResponseEntity.ok(true);
    }
}
