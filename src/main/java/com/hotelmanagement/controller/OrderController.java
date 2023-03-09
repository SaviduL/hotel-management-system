package com.hotelmanagement.controller;

import com.hotelmanagement.dto.*;
import com.hotelmanagement.service.OrderServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1.0/orders")
public class OrderController {
    @Autowired
    private OrderServiceable orderServiceable;

    @GetMapping()
    public ResponseEntity<List<ResourceOrderDTO>> index() {
        return ResponseEntity.ok(orderServiceable.getAllOrders());
    }

    @PostMapping()
    public ResponseEntity<Boolean> store(@RequestBody StoreOrderDTO storeOrderDTO) {
        return orderServiceable.createOrder(storeOrderDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceOrderDTO> show(@PathVariable Integer id) {
        return ResponseEntity.ok(orderServiceable.getOrderByID(id));
    }

    @PutMapping("/acceptOrderByChef/{id}")
    public ResponseEntity<Boolean> acceptOrderByChef(@PathVariable Integer id, @RequestBody ChangeStatusOrderDTO changeStatusOrderDTO) {
        changeStatusOrderDTO.setId(id);
        return orderServiceable.acceptOrderByChef(changeStatusOrderDTO);
    }

    @PutMapping("/preparedOrderByChef/{id}")
    public ResponseEntity<Boolean> preparedOrderByChef(@PathVariable Integer id, @RequestBody ChangeStatusOrderDTO changeStatusOrderDTO) {
        changeStatusOrderDTO.setId(id);
        return orderServiceable.preparedOrderByChef(changeStatusOrderDTO);
    }

    @PutMapping("/completeOrder/{id}")
    public ResponseEntity<Boolean> completeOrder(@PathVariable Integer id, @RequestBody ChangeStatusOrderDTO changeStatusOrderDTO) {
        changeStatusOrderDTO.setId(id);
        return orderServiceable.completeOrder(changeStatusOrderDTO);
    }

    @PutMapping("/cancelOrder/{id}")
    public ResponseEntity<Boolean> cancelOrder(@PathVariable Integer id, @RequestBody ChangeStatusOrderDTO changeStatusOrderDTO) {
        changeStatusOrderDTO.setId(id);
        return orderServiceable.cancelOrder(changeStatusOrderDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Integer id) {
        return orderServiceable.deleteOrder(id);
    }
}
