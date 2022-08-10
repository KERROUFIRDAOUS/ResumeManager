package com.app.GestionCv.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.GestionCv.model.Categorie;
import com.app.GestionCv.model.SousCategorie;
import com.app.GestionCv.services.CategorieService;
import com.app.GestionCv.services.SousCategorieService;
import com.app.GestionCv.services.UserService;
import com.app.GestionCv.web.dto.UserRegistrationDto;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	private CategorieService categorieService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private SousCategorieService sousCategorieService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("sousCategorie", sousCategorieService.getAllSousCategories());
		model.addAttribute("categories", categorieService.getAllCategories());
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/login?success";
	}

	@ResponseBody
	@RequestMapping(value = "loadSousCategoriesByCategories/{id}", method = RequestMethod.GET)
	public Collection<SousCategorie> loadSousCategoieByCategorie(@PathVariable("id") Long id) {
		Categorie categorie = categorieService.getCategorieById(id);
		return categorie.getSousCategories();
	}
	
}
