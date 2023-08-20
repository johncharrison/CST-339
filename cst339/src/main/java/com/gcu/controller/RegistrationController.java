package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.User;
import com.gcu.repository.UserRepository;

@Controller
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") @Validated User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}

		// You can add password hashing and other user-related logic here
		userRepository.save(user);
		return "redirect:/login"; // Redirect to login page
	}

}
