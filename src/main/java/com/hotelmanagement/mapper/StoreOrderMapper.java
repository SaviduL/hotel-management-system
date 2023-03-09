package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.StoreOrderDTO;
import com.hotelmanagement.entity.Order;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreOrderMapper {
    @Mapping(source = "waiterId", target = "waiterID.id")
    Order storeOrderDTOToOrder(StoreOrderDTO storeOrderDTO);

    @Mapping(source = "waiterID.id", target = "waiterId")
    StoreOrderDTO orderToStoreOrderDTO(Order order);

    @Mapping(source = "waiterId", target = "waiterID.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order updateOrderFromStoreOrderDTO(StoreOrderDTO storeOrderDTO, @MappingTarget Order order);

    @AfterMapping
    default void linkBills(@MappingTarget Order order) {
        order.getBills().forEach(bill -> bill.setOrderID(order));
    }
}
