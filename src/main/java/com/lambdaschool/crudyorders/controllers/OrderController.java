package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //localhost:5280/orders/order/:ordnum
    @GetMapping(value = "/order/{receipt}", produces = "application/json")
    public ResponseEntity<?> findOrderData(@PathVariable long receipt) {
        Order uniqueOrder = orderService.getReceipt(receipt);
        return new ResponseEntity<>(uniqueOrder, HttpStatus.OK);
    }

    //STRETCH
    //localhost:5280/orders/advanceamount
}
