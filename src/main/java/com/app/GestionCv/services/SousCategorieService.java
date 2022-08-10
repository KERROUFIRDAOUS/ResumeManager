package com.app.GestionCv.services;

import java.util.List;


import com.app.GestionCv.model.SousCategorie;

public interface SousCategorieService {	
	List<SousCategorie> getAllSousCategories();
	void saveSousCategorie(SousCategorie sousCategorie);
	SousCategorie getSousCategorieById(Long id);
	void deleteSousCategorieById(Long id);
	public List<SousCategorie> findByCategorie(Long id);
}
