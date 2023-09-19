package com.gcu.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.User;
import com.gcu.service.RegistrationService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	private final RegistrationService registrationService;

	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping
	public String registerUser(@Validated User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "register";
		}
		registrationService.registerUser(user);
		System.out.println("Registered user!");
		return "redirect:/login";
	}

}
