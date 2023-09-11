package com.gcu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.ProductRepository;
import com.gcu.model.Product;

@Service
public class ProductService implements ServiceInterface<Product> {

    @Autowired
    private ProductRepository repository;

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product save(Product model) {
        return repository.save(model);
    }

    public void delete(long id) {
        Optional<Product> query = repository.findById(id);
        if (query.isPresent()) {
            repository.delete(query.get());
        }
    }

    @Override
    public Product findById(long id) {
        Optional<Product> query = repository.findById(id);
        if (query.isPresent()) {
            return query.get();
        } else {
            return null;
        }
    }

    @Override
    public Product update(Product p) {
        Optional<Product> query = repository.findById(p.getId());
        if (query.isPresent()) {
            Product pInDB = query.get();
            pInDB.setName(p.getName());
            pInDB.setPrice(p.getPrice());
            pInDB.setDescription(p.getDescription());
            pInDB.setStock(p.getStock());
            return repository.save(pInDB);
        } else {
            return null;
        }
    }

}
