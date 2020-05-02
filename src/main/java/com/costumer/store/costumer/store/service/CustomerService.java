package com.costumer.store.costumer.store.service;

import com.costumer.store.costumer.store.entity.Customer;
import com.costumer.store.costumer.store.model.CustomerModel;
import com.costumer.store.costumer.store.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository custumerRepository;

    public boolean createNewUser(CustomerModel customerModel){
        Customer customer = new Customer();
        customer.setName(customerModel.getName());
        customer.setEmail(customerModel.getEmail());
        customer.setUser(customerModel.getUser());
        customer.setPhone(customerModel.getPhone());
        customer.setSurname(customerModel.getSurname());
        customer.setPassword(customerModel.getPassword());
        try {
            custumerRepository.save(customer);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    public Optional<Customer> findByUser(String user){
         return custumerRepository.findByUser(user);
    }

    public Iterable<Customer> findCustomersByEmailType(String type){
        return custumerRepository.findCustomersByEmailType(type);
    }

    /*public int logCustomer(CustomerModel m){


    }

    public Customer findCustomerByUser(CustomerModel customerModel){

    }

    public Iterable<Customer> getAllCostumers(){

    }

    public int saveNewCustomer(CustomerModel customerModel){

    }

    public Customer removeCustomer(CustomerModel customerModel){

    }

    public Customer findCustomerByEmail(CustomerModel customerModel){

    }

    public ProductModel order(CustomerModel customerModel,ProductModel){

    }*/

}
