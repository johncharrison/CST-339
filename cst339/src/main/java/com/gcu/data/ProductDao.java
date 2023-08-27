package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.Product;

@Service
public class ProductDao implements DaoInterface<Product> {

    public List<Product> list() {
        // return all the products from the DB
        // this could be a lot of records, so pagination will be needed
        // future implmentation will allow for filters to narrow down results
        List<Product> ps = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ps.add(new Product(i, "Product " + i, "description " + i, (float) i + (float) 0.70, 10, false,
                    "path/" + i + ".png"));
        }
        return ps;
    }

    public Product get(int id) {
        // retrieve product where id == product id
        Product p = new Product(id, "Product " + id, "description " + id, (float) id + (float) 0.70, 10, false,
                "path/" + id + ".png");
        return p;
    }

    public Product create(Product p) {
        // insert new p in DB
        return p;
    }

    public Product update(int id, Product p) {
        // retrieve product where id == product.id from DB
        // update it
        // put it back
        // return the newly updated model
        return p;
    }

    public void delete(int id) {
        // delete product where id == product.id from DB

    }

}
