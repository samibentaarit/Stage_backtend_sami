package com.example.stage_backend.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ligne")
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "annee_scolaire_id")
    private AnneeScolaire anneeScolaire;
    
    
    private String nomLigne;
    private String typeTrajet;

    @ManyToMany
    @JoinTable(
        name = "ligne_station",
        joinColumns = @JoinColumn(name = "ligne_id"),
        inverseJoinColumns = @JoinColumn(name = "station_id")
    )
    private List<Station> stations;
    private String etat;


    public Ligne() {
    }

    public Ligne(AnneeScolaire anneeScolaire, String nomLigne, String typeTrajet, List<Station> stations) {
        this.anneeScolaire = anneeScolaire;
        this.nomLigne = nomLigne;
        this.typeTrajet = typeTrajet;
        this.stations = stations;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public String getNomLigne() {
		return nomLigne;
	}

	public void setNomLigne(String nomLigne) {
		this.nomLigne = nomLigne;
	}

	public String getTypeTrajet() {
		return typeTrajet;
	}

	public void setTypeTrajet(String typeTrajet) {
		this.typeTrajet = typeTrajet;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Ligne(Long id, AnneeScolaire anneeScolaire, String nomLigne, String typeTrajet, List<Station> stations,
			String etat) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
		this.nomLigne = nomLigne;
		this.typeTrajet = typeTrajet;
		this.stations = stations;
		this.etat = etat;
	}
    
}