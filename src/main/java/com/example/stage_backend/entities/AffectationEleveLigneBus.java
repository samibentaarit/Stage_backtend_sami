package com.example.stage_backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class AffectationEleveLigneBus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "annee_scolaire_id")
    private AnneeScolaire anneeScolaire;
    
    public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	@ManyToMany
    @JoinTable(
            name = "affectation_eleve_ligne_bus_eleve",
            joinColumns = @JoinColumn(name = "affectation_id"),
            inverseJoinColumns = @JoinColumn(name = "eleve_id")
    )
    private List<Eleve> eleves;

    @ManyToMany
    @JoinTable(
            name = "affectation_eleve_ligne_bus_ligne",
            joinColumns = @JoinColumn(name = "affectation_id"),
            inverseJoinColumns = @JoinColumn(name = "ligne_id")
    )
    private List<Ligne> listDesLignes;

    @ManyToMany
    @JoinTable(
            name = "affectation_eleve_ligne_bus_bus",
            joinColumns = @JoinColumn(name = "affectation_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_id")
    )
    private List<Bus> listDesBus;

    @ManyToMany
    @JoinTable(
            name = "affectation_eleve_ligne_bus_station_aller",
            joinColumns = @JoinColumn(name = "affectation_id"),
            inverseJoinColumns = @JoinColumn(name = "station_aller_id")
    )
    private List<Station> stationAller;

    @ManyToMany
    @JoinTable(
            name = "affectation_eleve_ligne_bus_station_retour",
            joinColumns = @JoinColumn(name = "affectation_id"),
            inverseJoinColumns = @JoinColumn(name = "station_retour_id")
    )
    private List<Station> stationRetour;
    private String etat;

    
    public AffectationEleveLigneBus() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	public List<Ligne> getListDesLignes() {
		return listDesLignes;
	}

	public void setListDesLignes(List<Ligne> listDesLignes) {
		this.listDesLignes = listDesLignes;
	}

	public List<Bus> getListDesBus() {
		return listDesBus;
	}

	public void setListDesBus(List<Bus> listDesBus) {
		this.listDesBus = listDesBus;
	}

	public List<Station> getStationAller() {
		return stationAller;
	}

	public void setStationAller(List<Station> stationAller) {
		this.stationAller = stationAller;
	}

	public List<Station> getStationRetour() {
		return stationRetour;
	}

	public void setStationRetour(List<Station> stationRetour) {
		this.stationRetour = stationRetour;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public AffectationEleveLigneBus(Long id, AnneeScolaire anneeScolaire, List<Eleve> eleves, List<Ligne> listDesLignes,
			List<Bus> listDesBus, List<Station> stationAller, List<Station> stationRetour, String etat) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
		this.eleves = eleves;
		this.listDesLignes = listDesLignes;
		this.listDesBus = listDesBus;
		this.stationAller = stationAller;
		this.stationRetour = stationRetour;
		this.etat = etat;
	}

    
}
