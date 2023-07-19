
package com.example.stage_backend.entities;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name="personnel", schema = "public")
public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nom;
    private String prenom;
    private String email;
    private String fonction;
    private String etat;


    @ElementCollection
    @CollectionTable(name = "personnel_numtel", joinColumns = @JoinColumn(name = "personnel_id"))
    @Column(name = "num")
    private List<String> num;
    // Ajoutez ici une liste pour les numéros de parents si vous souhaitez en ajouter plusieurs


    @OneToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFonction() {
		return fonction;
	}


	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public List<String> getNum() {
		return num;
	}


	public void setNum(List<String> num) {
		this.num = num;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
    
}
