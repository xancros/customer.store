package com.costumer.store.costumer.store.controller;

import com.costumer.store.costumer.store.entity.Customer;
import com.costumer.store.costumer.store.entity.SingleOrder;
import com.costumer.store.costumer.store.model.CustomerModel;
import com.costumer.store.costumer.store.model.ProductModel;
import com.costumer.store.costumer.store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

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

    @GetMapping(path = "/users/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

   @PostMapping(path = "/users/saveProduct&userName={userName}&productName={productName}")
    public SingleOrder saveSingleProductOrder(@PathVariable("userName") String userName, @PathVariable("productName") String productName){
        return customerService.storeSingleOrder(userName,productName);
   }
}
