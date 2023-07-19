package com.example.stage_backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "num_bus")
	private int num_bus;

	@Column(name = "marque_bus")
	private String marque_bus;
	
	@Column(name = "immatriculation_bus")
	private String immatriculation_bus;
	
	@Column(name = "nb_places")
	private int nb_places;

	private String etat;
	
	public Bus() {

	}

	public Bus(int num_bus, String marque_bus, String immatriculation_bus,int nb_places) {
		super();
		this.num_bus = num_bus;
		this.marque_bus = marque_bus;
		this.immatriculation_bus=immatriculation_bus;
		this.nb_places=nb_places;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNum_bus() {
		return num_bus;
	}

	public void setNum_bus(int num_bus) {
		this.num_bus = num_bus;
	}

	public String getMarque_bus() {
		return marque_bus;
	}

	public void setMarque_bus(String marque_bus) {
		this.marque_bus = marque_bus;
	}

	public String getImmatriculation_bus() {
		return immatriculation_bus;
	}

	public void setImmatriculation_bus(String immatriculation_bus) {
		this.immatriculation_bus = immatriculation_bus;
	}

	public int getNb_places() {
		return nb_places;
	}

	public void setNb_places(int nb_places) {
		this.nb_places = nb_places;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	

}