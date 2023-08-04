package com.example.stage_backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "classe", schema = "public")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cycle;
    private String niveau;
    private String numClasse;
    private String etat;

    @ManyToOne
    @JoinColumn(name = "annee_scolaire_id")
    private AnneeScolaire anneeScolaire;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getNumClasse() {
		return numClasse;
	}

	public void setNumClasse(String numClasse) {
		this.numClasse = numClasse;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}
}

