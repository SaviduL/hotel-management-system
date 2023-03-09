package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceOrderDTO;
import com.hotelmanagement.entity.Order;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceOrderMapper {
    @Mapping(source = "waiterId", target = "waiterID.id")
    @Mapping(source = "waiterEmployee", target = "waiterID.employees")
    @Mapping(source = "chefId", target = "chefID.id")
    @Mapping(source = "chefEmployee", target = "chefID.employees")
    @Mapping(source = "cashierId", target = "cashierID.id")
    @Mapping(source = "cashierEmployee", target = "cashierID.employees")
    Order resourceOrderDTOToOrder(ResourceOrderDTO resourceOrderDTO);

    @InheritInverseConfiguration(name = "resourceOrderDTOToOrder")
    ResourceOrderDTO orderToResourceOrderDTO(Order order);

    @InheritConfiguration(name = "resourceOrderDTOToOrder")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order updateOrderFromResourceOrderDTO(ResourceOrderDTO resourceOrderDTO, @MappingTarget Order order);

    @AfterMapping
    default void linkBills(@MappingTarget Order order) {
        order.getBills().forEach(bill -> bill.setOrderID(order));
    }
}
