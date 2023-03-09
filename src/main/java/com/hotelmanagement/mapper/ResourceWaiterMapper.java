package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceWaiterDTO;
import com.hotelmanagement.entity.Waiter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceWaiterMapper {
    @Mapping(source = "employee", target = "employees")
    Waiter resourceWaiterDTOToWaiter(ResourceWaiterDTO resourceWaiterDTO);

    @Mapping(source = "employees", target = "employee")
    ResourceWaiterDTO waiterToResourceWaiterDTO(Waiter waiter);

    @Mapping(source = "employee", target = "employees")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Waiter updateWaiterFromResourceWaiterDTO(ResourceWaiterDTO resourceWaiterDTO, @MappingTarget Waiter waiter);
}
