package com.app.GestionCv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.app.GestionCv.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Lister les users
	@GetMapping("/admin/users")
	public String viewHomePage(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "admin/users";
	}
}
