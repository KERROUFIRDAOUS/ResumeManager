package com.app.GestionCv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.GestionCv.model.Categorie;
import com.app.GestionCv.services.CategorieService;

@Controller
public class CategorieController {
	@Autowired
	private CategorieService categorieService;

	@GetMapping("/admin")
	public String home() {
		return "admin/index";
	}
	
	// Lister les catégories
	@GetMapping("/admin/categories")
	public String viewHomePage(Model model) {
		model.addAttribute("listCategories", categorieService.getAllCategories());
		return "admin/categories";
	}

	@GetMapping("/showNewCategorieForm")
	public String showNewCategorieForm(Model model) {
		// create model attribute to bind form data
		Categorie categorie = new Categorie();
		model.addAttribute("categorie", categorie);
		return "admin/new_categorie";
	}
	
	@PostMapping("/saveCategorie")
    public String saveCategorie(@ModelAttribute("categorie") Categorie categorie) {
		categorieService.saveCategorie(categorie);
        return "redirect:/admin/categories";
    }
	
	@GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Categorie categorie = categorieService.getCategorieById(id);
        model.addAttribute("categorie", categorie);
        return "admin/update_categorie";
    }
	
	@GetMapping("/deleteCategorie/{id}")
    public String deleteCategorie(@PathVariable(value = "id") long id) {
        this.categorieService.deleteCategorieById(id);
        return "redirect:/admin/categories";
    }
}
