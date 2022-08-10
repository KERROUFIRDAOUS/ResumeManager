package com.app.GestionCv.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.GestionCv.model.User;
import com.app.GestionCv.services.CvService;
import com.app.GestionCv.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	CvService cvService;
	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home(Model model , HttpServletResponse httpResponse) throws IOException {
		model.addAttribute("cvs", cvService.hasCv());
		User user = userService.getUserConnected();
		if(user.getId() == 3) {
			httpResponse.sendRedirect("/admin");
		}
		return "index";
	}
}
