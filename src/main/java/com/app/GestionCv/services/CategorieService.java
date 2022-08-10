package com.app.GestionCv.services;

import java.util.List;

import com.app.GestionCv.model.Categorie;

public interface CategorieService {
	List<Categorie> getAllCategories();
	void saveCategorie(Categorie categorie);
	Categorie getCategorieById(Long id);
	void deleteCategorieById(Long id);
}
