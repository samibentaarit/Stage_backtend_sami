package com.example.stage_backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String immatriculation;
    private String marqueModele;
    private int nombrePlaces;
    private String etat;


    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getImmatriculation() {
		return immatriculation;
	}


	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}


	public String getMarqueModele() {
		return marqueModele;
	}


	public void setMarqueModele(String marqueModele) {
		this.marqueModele = marqueModele;
	}


	public int getNombrePlaces() {
		return nombrePlaces;
	}


	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public Agence getAgence() {
		return agence;
	}


	public void setAgence(Agence agence) {
		this.agence = agence;
	}


	@ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

}
