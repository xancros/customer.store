package com.costumer.store.costumer.store.repository;

import com.costumer.store.costumer.store.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>, CustomerRepositoryCustom{
    Optional<Customer> findByUser(String user);
}
