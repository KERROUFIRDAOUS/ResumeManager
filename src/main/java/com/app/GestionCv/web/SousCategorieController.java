package com.app.GestionCv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.GestionCv.model.SousCategorie;
import com.app.GestionCv.services.CategorieService;
import com.app.GestionCv.services.SousCategorieService;

@Controller
public class SousCategorieController {
	
	@Autowired 
	private SousCategorieService sousCategorieService;
	
	@Autowired 
	private CategorieService categorieService;
	
	@GetMapping("/admin/sousCategories")
	public String viewHomePage(Model model) {
		model.addAttribute("listSousCategories", sousCategorieService.getAllSousCategories());
		return "admin/sousCategories";
	}

	@GetMapping("/showNewSousCategorieForm")
	public String showNewSousCategorieForm(Model model) {
		SousCategorie sousCategorie = new SousCategorie();
		model.addAttribute("sousCategorie", sousCategorie);
		model.addAttribute("categories", categorieService.getAllCategories());
		return "admin/new_sousCategorie";
	}
	
	@PostMapping("/saveSousCategorie")
    public String saveSousCategorie(@ModelAttribute("sousCategorie") SousCategorie sousCategorie) {
		sousCategorieService.saveSousCategorie(sousCategorie);
        return "redirect:/admin/sousCategories";
    }
	
	@GetMapping("/showFormForUpdateSousCategoire/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		SousCategorie sousCategorie = sousCategorieService.getSousCategorieById(id);
        model.addAttribute("sousCategorie", sousCategorie);
        model.addAttribute("categories", categorieService.getAllCategories());
        return "admin/update_sousCategorie";
    }
	
	@GetMapping("/deleteSousCategorie/{id}")
    public String deleteSousCategorie(@PathVariable(value = "id") long id) {
        this.sousCategorieService.deleteSousCategorieById(id);
        return "redirect:/admin/sousCategories";
    }
	
}
