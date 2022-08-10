package com.app.GestionCv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.GestionCv.model.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
