package com.hotelmanagement.service.impl;

import com.hotelmanagement.dto.*;
import com.hotelmanagement.entity.Bill;
import com.hotelmanagement.entity.BillId;
import com.hotelmanagement.entity.Order;
import com.hotelmanagement.mapper.*;
import com.hotelmanagement.repository.OrderRepository;
import com.hotelmanagement.service.BillServiceable;
import com.hotelmanagement.service.OrderServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService implements OrderServiceable {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BillServiceable billServiceable;
    @Autowired
    private StoreOrderMapper storeOrderMapper;
    @Autowired
    private ChangeStatusOrderMapper changeStatusOrderMapper;
    @Autowired
    private ResourceOrderMapper resourceOrderMapper;

    @Override
    public List<ResourceOrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(resourceOrderMapper::orderToResourceOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Boolean> createOrder(StoreOrderDTO storeOrderDTO) {
        Order order = storeOrderMapper.storeOrderDTOToOrder(storeOrderDTO);
        Integer orderID = orderRepository.addOrder(
                order.getWaiterID().getId()
        );

        Set<Bill> bills = new LinkedHashSet<>();

        for (StoreBillDTO storeBillDTO : storeOrderDTO.getBills()) {
            Bill bill = new Bill();
            bill.setId(new BillId());
            bill.getId().setOrderID(orderID);
            bill.getId().setItemID(storeBillDTO.getItemId());
            bill.setUnitPrice(storeBillDTO.getUnitPrice());
            bill.setQuantity(storeBillDTO.getQuantity());

            bills.add(bill);
        }

        return billServiceable.createBill(bills);
    }

    @Override
    public ResourceOrderDTO getOrderByID(Integer id) {
        return resourceOrderMapper.orderToResourceOrderDTO(orderRepository.getById(id));
    }

    @Override
    public ResponseEntity<Boolean> acceptOrderByChef(ChangeStatusOrderDTO changeStatusOrderDTO) {
        Order order = changeStatusOrderMapper.changeStatusOrderDTOToOrder(changeStatusOrderDTO);
        orderRepository.acceptOrderBychef(
                order.getId(),
                order.getChefID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> preparedOrderByChef(ChangeStatusOrderDTO changeStatusOrderDTO) {
        Order order = changeStatusOrderMapper.changeStatusOrderDTOToOrder(changeStatusOrderDTO);
        orderRepository.preparedOrderBychef(
                order.getId(),
                order.getChefID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> completeOrder(ChangeStatusOrderDTO changeStatusOrderDTO) {
        Order order = changeStatusOrderMapper.changeStatusOrderDTOToOrder(changeStatusOrderDTO);
        orderRepository.completeOrder(
                order.getId(),
                order.getCashierID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> cancelOrder(ChangeStatusOrderDTO changeStatusOrderDTO) {
        Order order = changeStatusOrderMapper.changeStatusOrderDTOToOrder(changeStatusOrderDTO);
        orderRepository.cancelOrder(
                order.getId(),
                order.getChefID().getId()
        );
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> deleteOrder(Integer id) {
        orderRepository.deleteOrder(id);
        return ResponseEntity.ok(true);
    }
}
