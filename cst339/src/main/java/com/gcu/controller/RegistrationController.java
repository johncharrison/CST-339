package com.gcu.controller;

import com.gcu.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @GetMapping("")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        System.out.println("...this is where we would save the user in the database...IF WE HAD ONE");
        return "redirect:/login"; // Redirect to login page
    }

}
