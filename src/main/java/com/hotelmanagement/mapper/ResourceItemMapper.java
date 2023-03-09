package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceItemDTO;
import com.hotelmanagement.entity.Item;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceItemMapper {
    Item resourceItemDTOToItem(ResourceItemDTO resourceItemDTO);

    ResourceItemDTO itemToResourceItemDTO(Item item);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Item updateItemFromResourceItemDTO(ResourceItemDTO resourceItemDTO, @MappingTarget Item item);
}
