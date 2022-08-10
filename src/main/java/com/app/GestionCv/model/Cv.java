package com.app.GestionCv.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name =  "cvs")
public class Cv implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //générer automatiquement pas la bdd
    private Long id;
    @OneToOne
    private User candidat;
    @OneToOne
    private SousCategorie sousCategorie;
    @Lob
	private byte[] document;
       
	public Cv() {
	
	}

	public Cv(User candidat, SousCategorie sousCategorie, byte[] document) {
		this.candidat = candidat;
		this.sousCategorie = sousCategorie;
		this.document = document;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCandidat() {
		return candidat;
	}

	public void setCandidat(User candidat) {
		this.candidat = candidat;
	}

	public SousCategorie getSousCategorie() {
		return sousCategorie;
	}

	public void setSousCategorie(SousCategorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}
    
	
}
