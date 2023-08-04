package com.example.stage_backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class AffectationLigneBus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "annee_scolaire_id")
    private AnneeScolaire anneeScolaire;
    
    @ManyToMany
    @JoinTable(
            name = "listDesLignes_dans_Affectation",
            joinColumns = @JoinColumn(name = "affectation_id"),
            inverseJoinColumns = @JoinColumn(name = "ligne_id")
    )
    private List<Ligne> listDesLignes;

    @ManyToMany
    @JoinTable(
            name = "listDesBus_dans_Affectation",
            joinColumns = @JoinColumn(name = "affectation_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_id")
    )
    private List<Bus> listDesBus;

    @ManyToMany
    @JoinTable(
            name = "listDesChauffeurs_dans_Affectation",
            joinColumns = @JoinColumn(name = "affectation_id"),
            inverseJoinColumns = @JoinColumn(name = "chauffeur_id")
    )
    private List<Chauffeur> listDesChauffeurs;
    private String etat;

    // Add constructors, getters, setters, and any additional methods as needed.

    public AffectationLigneBus() {
    }

    public Long getId() {
		return id;
	}

	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Chauffeur> getListDesChauffeurs() {
		return listDesChauffeurs;
	}

	public void setListDesChauffeurs(List<Chauffeur> listDesChauffeurs) {
		this.listDesChauffeurs = listDesChauffeurs;
	}



	public AffectationLigneBus(Long id, AnneeScolaire anneeScolaire, List<Ligne> listDesLignes, List<Bus> listDesBus,
			List<Chauffeur> listDesChauffeurs, String etat) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
		this.listDesLignes = listDesLignes;
		this.listDesBus = listDesBus;
		this.listDesChauffeurs = listDesChauffeurs;
		this.etat = etat;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
}
