package com.app.GestionCv.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.app.GestionCv.model.SousCategorie;


public interface SousCategorieRepository extends JpaRepository<SousCategorie, Long> {
	
	@Query("select new com.app.GestionCv.model.Categorie(id, nom) from SousCategorie where categorie.id = :id")
	public List<SousCategorie> findByCategorie(@Param("id") Long id);
}
