package com.costumer.store.costumer.store.service;

import com.costumer.store.costumer.store.entity.Customer;
import com.costumer.store.costumer.store.entity.SingleOrder;
import com.costumer.store.costumer.store.model.CustomerModel;
import com.costumer.store.costumer.store.model.ProductModel;
import com.costumer.store.costumer.store.repository.CustomerRepository;
import com.costumer.store.costumer.store.repository.SingleOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SingleOrderRepository singleOrderRepository;

    public boolean createNewUser(CustomerModel customerModel){
        Customer customer = new Customer();
        customer.setName(customerModel.getName());
        customer.setEmail(customerModel.getEmail());
        customer.setUser(customerModel.getUser());
        customer.setPhone(customerModel.getPhone());
        customer.setSurname(customerModel.getSurname());
        customer.setPassword(customerModel.getPassword());
        try {
            customerRepository.save(customer);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    public Optional<Customer> findByUser(String user){
         return customerRepository.findByUser(user);
    }

    public Iterable<Customer> findCustomersByEmailType(String type){
        return customerRepository.findCustomersByEmailType(type);
    }

    public List<Customer> getAllCustomers(){return customerRepository.findAll();}

    public SingleOrder storeSingleOrder(String userName, String productName){
        Optional<Customer> customerOptional = this.findByUser(userName);
        //Call Store service to find the product
        ProductModel productModel = restTemplate.getForObject("http://THEBESTSTORE/products/findProduct&name="+productName,ProductModel.class);
        /*
        Product:{
                  "id": 1,
                  "name": "TestProduct",
                  "category": 1,
                  "price": 1.2,
                  "visibility": 1
                }
         */

        if(customerOptional.isPresent() && productModel != null && productModel.getId()>=0) {
            SingleOrder singleOrder = new SingleOrder();
            singleOrder.setIdUser(customerOptional.get().getIdUser());
            singleOrder.setUserName(customerOptional.get().getUser());
            singleOrder.setProductName(productModel.getName());
            try {
                singleOrderRepository.save(singleOrder);
                return singleOrder;
            } catch (Exception ex) {
                return null;
            }
        }
        return null;

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
