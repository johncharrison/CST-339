package com.gcu.controller.product;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.api.RestInterface;
import com.gcu.api.RestService;
import com.gcu.model.Product;

@Controller
@RequestMapping("/products")
public class ProductController {

    RestInterface<Product> service;

    public ProductController(RestService<Product> service) {
        this.service = service;
    }

    @GetMapping("")
    public ModelAndView products(ModelAndView mv) {
        mv.setViewName("products");
        mv.addObject("products", service.list());
        return mv;
    }

    @GetMapping(path = "/add-product")
    public ModelAndView createProductPage(ModelAndView mv, Product product) {
        mv.addObject("product", product);
        mv.setViewName("add-product");
        return mv;
    }

    @PostMapping(path = "/add-product")
    public String postCreateProduct(@Validated Product product, ModelAndView mv) {
        service.create(product);
        return "redirect:/products";
    }
}
