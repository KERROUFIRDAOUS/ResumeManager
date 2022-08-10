package com.app.GestionCv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.GestionCv.model.SousCategorie;
import com.app.GestionCv.repositories.SousCategorieRepository;

@Service
public class SousCategorieServiceImpl implements SousCategorieService{

	@Autowired
	SousCategorieRepository sousCategorieRepository;
	
	@Override
	public List<SousCategorie> getAllSousCategories() {
		return sousCategorieRepository.findAll();
	}

	@Override
	public void saveSousCategorie(SousCategorie sousCategorie) {
		this.sousCategorieRepository.save(sousCategorie);		
		
	}

	@Override
	public SousCategorie getSousCategorieById(Long id) {
		Optional<SousCategorie> optional = sousCategorieRepository.findById(id);
		SousCategorie sousCategorie = null;
        if (optional.isPresent()) {
        	sousCategorie = optional.get();
        } else {
            throw new RuntimeException(" sous categorie not found for id :: " + id);
        }
        return sousCategorie;
	}

	@Override
	public void deleteSousCategorieById(Long id) {
		this.sousCategorieRepository.deleteById(id);
		
	}
	
	@Override
	public List<SousCategorie> findByCategorie(Long id) {
		return sousCategorieRepository.findByCategorie(id);
	}

}
