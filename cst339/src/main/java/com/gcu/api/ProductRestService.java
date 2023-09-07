package com.gcu.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.ProductRepository;
import com.gcu.model.Product;

@Service
public class ProductRestService implements RestInterface<Product> {

    @Autowired
    private ProductRepository repository;

    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    public Product get(long id) {

        Optional<Product> query = repository.findById(id);
        if (query.isPresent()) {
            return query.get();
        } else {
            return null;
        }
    }

    public Product create(Product model) {
        return repository.save(model);
    }

    public Product update(long id, Product model) {
        Optional<Product> query = repository.findById(id);
        if (query.isPresent()) {
            Product pInDB = query.get();
            pInDB.setName(model.getName());
            pInDB.setPrice(model.getPrice());
            pInDB.setDescription(model.getDescription());
            pInDB.setStock(model.getStock());
            return repository.save(pInDB);
        } else {
            return null;
        }
    }

    public void delete(long id) {
        Optional<Product> query = repository.findById(id);
        if (query.isPresent()) {
            repository.delete(query.get());
        }
    }

}
