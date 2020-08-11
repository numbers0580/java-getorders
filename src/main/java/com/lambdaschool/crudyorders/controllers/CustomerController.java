package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //localhost:5280/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllOrders() {
        List<Customer> allOrders = customerService.getAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    //localhost:5280/customers/:custcode
    @GetMapping(value = "/{custid}", produces = "application/json")
    public ResponseEntity<?> findTargetedCustomer(@PathVariable long custid) {
        Customer specCustomer = customerService.getThatCustomer(custid);
        return new ResponseEntity<>(specCustomer, HttpStatus.OK);
    }

    //Test Only
    //localhost:5280/customers/:custcode(notfound)

    //localhost:5280/customers/namelike/:substring

    //Test Only
    //localhost:5280/customers/namelike/:substring(notfound)
}
