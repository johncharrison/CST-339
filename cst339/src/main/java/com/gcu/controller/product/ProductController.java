package com.gcu.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.api.RestInterface;
import com.gcu.api.ProductRestService;
import com.gcu.model.Product;

@Controller
@RequestMapping("/products")
public class ProductController {

    RestInterface<Product> service;

    public ProductController(ProductRestService service) {
        this.service = service;
    }

    @GetMapping("")
    public ModelAndView products(ModelAndView mv) {
        mv.setViewName("products");
        mv.addObject("products", service.findAll());
        return mv;
    }

    @GetMapping(path = "/add-product")
    public ModelAndView createProductPage(ModelAndView mv, Product product) {
        mv.addObject("product", product);
        mv.setViewName("add-product");
        return mv;
    }

    @GetMapping(path = "/product-detail/{id}")
    public ModelAndView detailProductPage(ModelAndView mv, Product product, @PathVariable long id) {
        product = service.get(id);
        mv.addObject("product", product);
        mv.setViewName("detail-product");
        return mv;

    }

    @GetMapping(path = "/update-product/{id}")
    public ModelAndView updateProductPage(ModelAndView mv, Product product, @PathVariable long id) {
        product = service.get(id);
        mv.addObject("product", product);
        mv.setViewName("update-product");
        return mv;

    }

    @PutMapping(path = "/update-product/{id}")
    public String createProductPage(ModelAndView mv, Product product, @PathVariable long id) {
        service.update(id, product);
        return "redirect:/products";
    }

    @PostMapping(path = "/add-product")
    public String postCreateProduct(@Validated Product product, ModelAndView mv) {
        System.out.println(
                String.format("Name: %s\nDescription: %s\nPrice: $%.2f\nStock: %d", product.getName(),
                        product.getDescription(), product.getPrice(),
                        product.getStock()));
        service.create(product);
        return "redirect:/products";
    }
}
