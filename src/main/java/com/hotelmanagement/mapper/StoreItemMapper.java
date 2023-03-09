package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.StoreItemDTO;
import com.hotelmanagement.entity.Item;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreItemMapper {
    Item storeItemDTOToItem(StoreItemDTO storeItemDTO);

    StoreItemDTO itemToStoreItemDTO(Item item);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Item updateItemFromStoreItemDTO(StoreItemDTO storeItemDTO, @MappingTarget Item item);
}
