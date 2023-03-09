package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.UpdateItemDTO;
import com.hotelmanagement.entity.Item;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UpdateItemMapper {
    Item updateItemDTOToItem(UpdateItemDTO updateItemDTO);

    UpdateItemDTO itemToUpdateItemDTO(Item item);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Item updateItemFromUpdateItemDTO(UpdateItemDTO updateItemDTO, @MappingTarget Item item);
}
