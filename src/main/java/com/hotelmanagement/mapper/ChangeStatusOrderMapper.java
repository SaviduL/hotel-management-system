package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ChangeStatusOrderDTO;
import com.hotelmanagement.entity.Order;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChangeStatusOrderMapper {
    @Mapping(source = "chefId", target = "chefID.id")
    @Mapping(source = "cashierId", target = "cashierID.id")
    Order changeStatusOrderDTOToOrder(ChangeStatusOrderDTO changeStatusOrderDTO);

    @InheritInverseConfiguration(name = "changeStatusOrderDTOToOrder")
    ChangeStatusOrderDTO orderToChangeStatusOrderDTO(Order order);

    @InheritConfiguration(name = "changeStatusOrderDTOToOrder")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order updateOrderFromChangeStatusOrderDTO(ChangeStatusOrderDTO changeStatusOrderDTO, @MappingTarget Order order);
}
