package com.app.GestionCv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.GestionCv.model.Categorie;
import com.app.GestionCv.repositories.CategorieRepository;

@Service
public class CategorieServiceImpl implements CategorieService{

	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public List<Categorie> getAllCategories() {
		return categorieRepository.findAll();
	}

	@Override
	public void saveCategorie(Categorie categorie) {
		this.categorieRepository.save(categorie);		
	}

	@Override
	public Categorie getCategorieById(Long id) {
		Optional<Categorie> optional = categorieRepository.findById(id);
		Categorie categorie = null;
        if (optional.isPresent()) {
        	categorie = optional.get();
        } else {
            throw new RuntimeException(" categorie not found for id :: " + id);
        }
        return categorie;
	}

	@Override
	public void deleteCategorieById(Long id) {
		this.categorieRepository.deleteById(id);
	}

}
