package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
