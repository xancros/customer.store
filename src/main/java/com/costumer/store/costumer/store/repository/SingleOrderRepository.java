package com.costumer.store.costumer.store.repository;

import com.costumer.store.costumer.store.entity.SingleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleOrderRepository extends JpaRepository<SingleOrder,Long> {
}
