package com.gcu.controller.product;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.api.RestInterface;
import com.gcu.api.ProductRestService;
import com.gcu.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    RestInterface<Product> service;

    public ProductRestController(ProductRestService service) {
        this.service = service;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product create(@RequestBody Product p) {
        return service.create(p);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product update(@PathVariable long id, @RequestBody Product p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

}
