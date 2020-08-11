package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository custrepos;

    @Override
    public List<Customer> getAllOrders() {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer getThatCustomer(long custid) {
        return custrepos.findById(custid).orElseThrow(() -> new EntityNotFoundException("Customer of ID # " + custid + " was nowhere to bee seen."));
    }

    @Override
    public List<Customer> getAllPartialNames(String partial) {
        return custrepos.findByCustnameContainingIgnoringCase(partial);
    }
}
