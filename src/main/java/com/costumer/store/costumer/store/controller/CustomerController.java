package com.costumer.store.costumer.store.controller;

import com.costumer.store.costumer.store.entity.Customer;
import com.costumer.store.costumer.store.model.CustomerModel;
import com.costumer.store.costumer.store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController (CustomerService customerService){this.customerService=customerService;}


    @PostMapping(path = "/users/create")
    public String createNewUser(@RequestBody CustomerModel customerModel){
        if(customerService.createNewUser(customerModel))
            return "Success";
        else
            return "Error creating the new customer";
    }

    @GetMapping(path = "/users/user={user}")
    public Customer findByUser(@PathVariable("user") String user){
        Optional<Customer> option = customerService.findByUser(user);
        return option.orElse(null);
    }

    @GetMapping(path = "/users/emailLike={type}")
    public Iterable<Customer> findCustomersWithSameEmailType(@PathVariable("type") String type){
        return customerService.findCustomersByEmailType(type);
    }
}
