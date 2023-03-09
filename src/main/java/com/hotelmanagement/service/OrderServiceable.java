package com.hotelmanagement.service;

import com.hotelmanagement.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderServiceable {
    List<ResourceOrderDTO> getAllOrders();

    ResponseEntity<Boolean> createOrder(StoreOrderDTO storeOrderDTO);

    ResourceOrderDTO getOrderByID(Integer id);

    ResponseEntity<Boolean> acceptOrderByChef(ChangeStatusOrderDTO changeStatusOrderDTO);

    ResponseEntity<Boolean> preparedOrderByChef(ChangeStatusOrderDTO changeStatusOrderDTO);

    ResponseEntity<Boolean> completeOrder(ChangeStatusOrderDTO changeStatusOrderDTO);

    ResponseEntity<Boolean> cancelOrder(ChangeStatusOrderDTO changeStatusOrderDTO);

    ResponseEntity<Boolean> deleteOrder(Integer id);
}
