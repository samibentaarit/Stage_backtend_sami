package com.example.stage_backend.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;



@Entity
@Table(name = "chauffeur")
public class Chauffeur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;
	

    @ElementCollection
    @CollectionTable(name = "chauffeur_numtel", joinColumns = @JoinColumn(name = "chauffeur_id"))
    @Column(name = "num")
    private List<String> num;
	
	@Column(name = "email")
	private String email;

	private String etat;
	
	public Chauffeur() {

	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<String> getNum() {
		return num;
	}


	public void setNum(List<String> num) {
		this.num = num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	

}