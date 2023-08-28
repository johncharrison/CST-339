package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.User;
import com.gcu.service.RegistrationServiceInterface;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	private final RegistrationServiceInterface registrationService;

	public RegistrationController(RegistrationServiceInterface registrationService) {
		this.registrationService = registrationService;
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/register")
	public String registerUser(@Validated User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		registrationService.registerUser(user);

		return "redirect:/login";
	}

}
