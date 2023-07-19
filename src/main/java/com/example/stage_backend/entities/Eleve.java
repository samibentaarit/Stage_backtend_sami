package com.example.stage_backend.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="eleve", schema = "public")
public class Eleve implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String nomPere;
    private String prenomPere;
    private String nomMere;
    private String prenomMere;
    private String nationalite;
    private String email;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomPere() {
		return nomPere;
	}

	public void setNomPere(String nomPere) {
		this.nomPere = nomPere;
	}

	public String getPrenomPere() {
		return prenomPere;
	}

	public void setPrenomPere(String prenomPere) {
		this.prenomPere = prenomPere;
	}

	public String getNomMere() {
		return nomMere;
	}

	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}

	public String getPrenomMere() {
		return prenomMere;
	}

	public void setPrenomMere(String prenomMere) {
		this.prenomMere = prenomMere;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
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

	public List<String> getNumTels() {
		return numTels;
	}

	public void setNumTels(List<String> numTels) {
		this.numTels = numTels;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ElementCollection
    @CollectionTable(name = "eleve_numtel", joinColumns = @JoinColumn(name = "eleve_id"))
    @Column(name = "numtel")
    private List<String> numTels;
    // Ajoutez ici une liste pour les numéros de parents si vous souhaitez en ajouter plusieurs

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
