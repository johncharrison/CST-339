package com.gcu.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.Product;
import com.gcu.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("")
    public ModelAndView allProducts(ModelAndView mv) {
        mv.addObject("products", service.findAll());
        mv.setViewName("products/products");
        return mv;
    }

    @GetMapping(path = "/product-add")
    public ModelAndView addProductPage(ModelAndView mv, Product product) {
        mv.addObject("product", product);
        mv.setViewName("products/product-add");
        return mv;
    }

    @PostMapping(path = "/product-add")
    public ResponseEntity<String> postProduct(@Validated Product product, ModelAndView mv) {
        System.out.println(
                String.format("Name: %s\nDescription: %s\nPrice: $%.2f\nStock: %d", product.getName(),
                        product.getDescription(), product.getPrice(),
                        product.getStock()));
        service.save(product);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("HX-Location", "/products");
        return new ResponseEntity<String>("", responseHeaders, 201);
    }

    @GetMapping(path = "/product-detail/{id}")
    public ModelAndView detailProductPage(ModelAndView mv, Product product, @PathVariable long id) {
        product = service.findById(id);
        mv.addObject("product", product);
        mv.setViewName("products/product-detail");
        return mv;

    }

    @GetMapping(path = "/product-update/{id}")
    public ModelAndView updateProductPage(ModelAndView mv, Product product, @PathVariable long id) {
        product = service.findById(id);
        mv.addObject("product", product);
        mv.setViewName("products/product-update");
        return mv;

    }

    @PutMapping(path = "/product-update/{id}")
    public ModelAndView putProduct(ModelAndView mv, Product product, @PathVariable long id) {
        service.update(product);
        mv.addObject("product", product);
        mv.setViewName("products/product-detail");
        return mv;
    }

    @DeleteMapping(path = "/product-delete/{id}")
    public ResponseEntity<String> deleteProduct(ModelAndView mv, @PathVariable long id) {
        service.delete(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("HX-Location", "/products");

        return new ResponseEntity<String>("", responseHeaders, 204);
    }

}
