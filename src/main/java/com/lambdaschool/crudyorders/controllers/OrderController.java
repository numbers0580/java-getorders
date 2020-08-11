package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //localhost:5280/orders/order/:ordnum

    //STRETCH
    //localhost:5280/orders/advanceamount
}
