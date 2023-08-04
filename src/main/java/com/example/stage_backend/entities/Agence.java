package com.example.stage_backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "agence")
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adresseSiege;
    private String responsable;
    private String email;

    @ElementCollection
    @CollectionTable(name = "agence_numtel", joinColumns = @JoinColumn(name = "agence_id"))
    @Column(name = "numtel")
    private List<String> numTels;

    private String etat;
    private String infoSupp;
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
	public String getAdresseSiege() {
		return adresseSiege;
	}
	public void setAdresseSiege(String adresseSiege) {
		this.adresseSiege = adresseSiege;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getNumTels() {
		return numTels;
	}
	public void setNumTels(List<String> numTels) {
		this.numTels = numTels;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getInfoSupp() {
		return infoSupp;
	}
	public void setInfoSupp(String infoSupp) {
		this.infoSupp = infoSupp;
	}

}

