package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceBillDTO;
import com.hotelmanagement.entity.Bill;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceBillMapper {
    @Mapping(source = "orderId", target = "orderID.id")
    @Mapping(source = "item", target = "itemID")
    Bill resourceBillDTOToBill(ResourceBillDTO resourceBillDTO);

    @InheritInverseConfiguration(name = "resourceBillDTOToBill")
    ResourceBillDTO billToResourceBillDTO(Bill bill);

    @InheritConfiguration(name = "resourceBillDTOToBill")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Bill updateBillFromResourceBillDTO(ResourceBillDTO resourceBillDTO, @MappingTarget Bill bill);
}
