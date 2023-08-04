package com.example.stage_backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String region;
    private String coordonneesGpsLatitude;
    private String coordonneesGpsLongitude;
    private String etat;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCoordonneesGpsLatitude() {
		return coordonneesGpsLatitude;
	}
	public void setCoordonneesGpsLatitude(String coordonneesGpsLatitude) {
		this.coordonneesGpsLatitude = coordonneesGpsLatitude;
	}
	public String getCoordonneesGpsLongitude() {
		return coordonneesGpsLongitude;
	}
	public void setCoordonneesGpsLongitude(String coordonneesGpsLongitude) {
		this.coordonneesGpsLongitude = coordonneesGpsLongitude;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
}
