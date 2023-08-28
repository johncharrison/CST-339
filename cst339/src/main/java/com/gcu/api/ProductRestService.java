package com.gcu.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.data.ProductDao;
import com.gcu.model.Product;

@Service
public class ProductRestService implements RestInterface<Product> {

    private final ProductDao dao;

    public ProductRestService(ProductDao dao) {
        this.dao = dao;
    }

    public Product create(Product model) {
        return dao.create(model);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public Product get(int id) {
        return dao.get(id);
    }

    public List<Product> list() {
        return dao.list();
    }

    public Product update(int id, Product model) {
        return dao.update(id, model);
    }

}
