package com.gcu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.OrderRepository;
import com.gcu.model.Order;

@Service
public class OrderService implements ServiceInterface<Order> {
    @Autowired
    private OrderRepository repository;

    @Override
    public Iterable<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order save(Order model) {
        return repository.save(model);
    }

    public void delete(long id) {
        Optional<Order> query = repository.findById(id);
        if (query.isPresent()) {
            repository.delete(query.get());
        }
    }

    @Override
    public Order findById(long id) {
        Optional<Order> query = repository.findById(id);
        if (query.isPresent()) {
            return query.get();
        } else {
            return null;
        }
    }

    @Override
    public Order update(Order o) {
        Optional<Order> query = repository.findById(o.getId());
        if (query.isPresent()) {
            Order oInDB = query.get();
            oInDB.setProducts_id(o.getProducts_id());
            oInDB.setQuantity(o.getQuantity());
            oInDB.setUsers_id(o.getUsers_id());
            oInDB.setCompleted(o.isCompleted());
            return repository.save(oInDB);
        } else {
            return null;
        }
    }
}
