package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceCashierDTO;
import com.hotelmanagement.entity.Cashier;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceCashierMapper {
    @Mapping(source = "employee", target = "employees")
    Cashier resourceCashierDTOToCashier(ResourceCashierDTO resourceCashierDTO);

    @Mapping(source = "employees", target = "employee")
    ResourceCashierDTO cashierToResourceCashierDTO(Cashier cashier);

    @Mapping(source = "employee", target = "employees")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cashier updateCashierFromResourceCashierDTO(ResourceCashierDTO resourceCashierDTO, @MappingTarget Cashier cashier);
}
