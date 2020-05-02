package com.costumer.store.costumer.store.repository;

import com.costumer.store.costumer.store.entity.Customer;

public interface CustomerRepositoryCustom {

    public Iterable<Customer> findCustomersByEmailType(String type);

}
