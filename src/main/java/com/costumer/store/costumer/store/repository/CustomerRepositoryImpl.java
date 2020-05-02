package com.costumer.store.costumer.store.repository;

import com.costumer.store.costumer.store.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional()
public class CustomerRepositoryImpl implements  CustomerRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
/*
        Query query = entityManager.createNativeQuery(
        "SELECT em.* FROM spring_data_jpa_example.employee as em " +

                "WHERE em.firstname LIKE ?", Employee.class);

        query.setParameter(1, firstName + "%");
 */
    @Override
    public List<Customer> findCustomersByEmailType(String type) {
        String sqlQuery = "Select c.* from t_costumer c where c.email like ?";
        Query query = entityManager.createNativeQuery(sqlQuery,Customer.class);
        query.setParameter(1, "%@"+type+".com");
        return query.getResultList();
    }
}
