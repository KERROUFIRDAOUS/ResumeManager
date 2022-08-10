package com.app.GestionCv.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name =  "sousCategories")
public class SousCategorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 45, nullable = false)
	private String nom;
	
	@ManyToOne
	@JsonIgnore
	private Categorie categorie;
	
	@OneToMany(mappedBy = "sousCategories")
	@JsonIgnore
	private Collection<User> users;

	public SousCategorie() {
		super();
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Collection<User> getUsers() {
		return users;
	}


	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	
	
}
