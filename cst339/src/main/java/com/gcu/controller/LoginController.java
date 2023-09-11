package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.User;
import com.gcu.service.LoginService;
import com.gcu.service.LoginServiceInterface;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginServiceInterface service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @GetMapping
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(String email, String password) {
        User u = service.login(email, password);

        if (u != null) {
            System.out.println(u.getLastName() + ", " + u.getFirstName());
            return "redirect:/products";
        }

        return "login";

    }
}
