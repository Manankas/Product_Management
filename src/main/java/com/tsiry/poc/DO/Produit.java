package com.tsiry.poc.DO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author tsiriniavo
 * @version 1.0
 * @created 21-fevr.-2018 17:42:01
 */
@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String designation;
	
	private double prix;
	
	@ManyToOne
	@JoinColumn(name = "cat", nullable = false)
	private Categorie categorie;
	
	public Produit(){
		super();
	}
	
	public Produit(Long id, String designation, double prix, Categorie categorie) {
		super();
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.categorie = categorie;
	}



	public Produit(String designation, double prix, Categorie categorie) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	

}