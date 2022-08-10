package com.app.GestionCv.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name =  "categories")
public class Categorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 45, nullable = false)
	private String nom;
	
	@OneToMany(mappedBy = "categorie")
	private Collection<SousCategorie> sousCategories;
	
	@OneToMany(mappedBy = "sousCategories")
	private Collection<User> users;

	public Categorie() {
		super();
	}

	
	public Categorie(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<SousCategorie> getSousCategories() {
		return sousCategories;
	}

	public void setSousCategories(Collection<SousCategorie> sousCategories) {
		this.sousCategories = sousCategories;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
	
}
