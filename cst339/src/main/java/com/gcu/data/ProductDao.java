package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.model.Product;

@Service
public class ProductDao implements DaoInterface<Product> {

    public List<Product> list() {
        List<Product> ps = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ps.add(new Product(i, "Product " + i, "description " + i, (float) i + (float) 0.70, 10, false,
                    "path/" + i + ".png"));
        }
        return ps;
    }

    public Product get(int id) {
        Product p = new Product(id, "Product " + id, "description " + id, (float) id + (float) 0.70, 10, false,
                "path/" + id + ".png");
        return p;
    }

    public Product create(Product model) {
        return model;
    }

}
