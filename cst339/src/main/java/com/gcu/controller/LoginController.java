package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.User;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Validated User user, BindingResult bindingResult) {
        // if User does not exist in db or password doesn't match
        // return "login" w/ errors
    	
    	  if (bindingResult.hasErrors()) {
              return "login";
          }

        return "products";
    }
}
